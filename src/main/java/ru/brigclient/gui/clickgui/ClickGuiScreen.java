package ru.brigclient.gui.clickgui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import ru.brigclient.BrigClient;
import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.ModuleManager;
import ru.brigclient.module.setting.*;
import ru.brigclient.util.ColorUtil;

import java.util.List;

/**
 * Modern semi-transparent dark ClickGUI.
 * LMB = toggle module, RMB = open settings panel.
 * Search bar at top.
 * Right Shift to open/close.
 *
 * NOTE: Does NOT call renderBackground() before super.render() to avoid "Can only blur once per frame".
 */
public class ClickGuiScreen extends Screen {

    private Category selectedCategory = Category.OPTIMIZATION;
    private String searchQuery = "";
    private Module expandedModule = null;
    private int scrollOffset = 0;

    // Theme
    private int primaryColor = ColorUtil.rgba(18, 18, 22, 230);
    private int accentColor = ColorUtil.rgba(0, 255, 170, 255);
    private int cardColor = ColorUtil.rgba(28, 28, 34, 220);
    private int borderColor = ColorUtil.rgba(80, 80, 90, 180);

    public ClickGuiScreen() {
        super(Text.literal("Brig Client"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Do NOT call renderBackground here before super to avoid blur error.
        // We draw our own dark overlay.
        context.fill(0, 0, this.width, this.height, ColorUtil.rgba(0, 0, 0, 140));

        super.render(context, mouseX, mouseY, delta);

        int leftW = 140;
        int topH = 40;

        // Left navigation panel
        context.fill(0, 0, leftW, this.height, primaryColor);
        context.fill(leftW - 1, 0, leftW, this.height, borderColor);

        // Logo / title
        context.drawText(textRenderer, "Brig Client", 16, 14, accentColor, true);
        context.drawText(textRenderer, "v1.0.0", 16, 26, ColorUtil.rgba(150, 150, 160, 255), false);

        // Category tabs
        int y = 50;
        for (Category cat : Category.values()) {
            boolean sel = cat == selectedCategory;
            int bg = sel ? ColorUtil.withAlpha(accentColor, 40) : ColorUtil.rgba(0, 0, 0, 0);
            context.fill(8, y, leftW - 8, y + 22, bg);
            if (sel) {
                context.fill(8, y, 11, y + 22, accentColor);
            }
            context.drawText(textRenderer, cat.getDisplayName(), 18, y + 7, sel ? accentColor : 0xFFCCCCCC, false);
            y += 26;
        }

        // Main content area
        int contentX = leftW + 12;
        int contentY = topH + 8;
        int contentW = this.width - leftW - 24;

        // Search bar
        context.fill(contentX, 10, contentX + contentW, 32, cardColor);
        context.fill(contentX, 10, contentX + contentW, 11, borderColor);
        String searchText = searchQuery.isEmpty() ? "Поиск модулей..." : searchQuery;
        int searchColor = searchQuery.isEmpty() ? 0xFF666666 : 0xFFFFFFFF;
        context.drawText(textRenderer, searchText, contentX + 8, 17, searchColor, false);

        // Modules grid / list
        ModuleManager mm = BrigClient.getInstance().getModuleManager();
        List<Module> modules = searchQuery.isEmpty()
                ? mm.getModulesByCategory(selectedCategory)
                : mm.search(searchQuery);

        int cardW = 180;
        int cardH = 36;
        int gap = 8;
        int cols = Math.max(1, contentW / (cardW + gap));
        int startY = contentY + scrollOffset;

        int i = 0;
        for (Module mod : modules) {
            int col = i % cols;
            int row = i / cols;
            int cx = contentX + col * (cardW + gap);
            int cy = startY + row * (cardH + gap);

            if (cy + cardH < contentY || cy > this.height) {
                i++;
                continue;
            }

            boolean hovered = mouseX >= cx && mouseX <= cx + cardW && mouseY >= cy && mouseY <= cy + cardH;
            int bg = mod.isEnabled() ? ColorUtil.withAlpha(accentColor, 50) : cardColor;
            if (hovered) bg = ColorUtil.withAlpha(bg, 255);

            // Card
            context.fill(cx, cy, cx + cardW, cy + cardH, bg);
            // Border
            int bCol = mod.isEnabled() ? accentColor : borderColor;
            context.fill(cx, cy, cx + cardW, cy + 1, bCol);
            context.fill(cx, cy + cardH - 1, cx + cardW, cy + cardH, bCol);
            context.fill(cx, cy, cx + 1, cy + cardH, bCol);
            context.fill(cx + cardW - 1, cy, cx + cardW, cy + cardH, bCol);

            // Name + status
            context.drawText(textRenderer, mod.getName(), cx + 8, cy + 8, 0xFFFFFFFF, false);
            String status = mod.isEnabled() ? "ON" : "OFF";
            int stCol = mod.isEnabled() ? accentColor : 0xFF888888;
            context.drawText(textRenderer, status, cx + cardW - 28, cy + 8, stCol, false);
            // Description truncated
            String desc = mod.getDescription();
            if (textRenderer.getWidth(desc) > cardW - 16) {
                desc = textRenderer.trimToWidth(desc, cardW - 20) + "..";
            }
            context.drawText(textRenderer, desc, cx + 8, cy + 20, 0xFFAAAAAA, false);

            i++;
        }

        // Expanded settings panel (right side if module selected)
        if (expandedModule != null) {
            int panelW = 220;
            int panelX = this.width - panelW - 12;
            context.fill(panelX, 40, this.width - 12, this.height - 12, primaryColor);
            context.fill(panelX, 40, panelX + 1, this.height - 12, accentColor);

            context.drawText(textRenderer, expandedModule.getName(), panelX + 10, 50, accentColor, true);
            context.drawText(textRenderer, "Настройки (ПКМ закрыть)", panelX + 10, 64, 0xFF888888, false);

            int sy = 90;
            for (Setting<?> s : expandedModule.getSettings()) {
                context.drawText(textRenderer, s.getName(), panelX + 12, sy, 0xFFDDDDDD, false);
                if (s instanceof BooleanSetting bs) {
                    String val = bs.getValue() ? "§aON" : "§cOFF";
                    context.drawText(textRenderer, val, panelX + panelW - 50, sy, 0xFFFFFFFF, false);
                } else if (s instanceof NumberSetting ns) {
                    context.drawText(textRenderer, String.format("%.2f", ns.getValue()), panelX + panelW - 60, sy, accentColor, false);
                } else if (s instanceof ModeSetting ms) {
                    context.drawText(textRenderer, ms.getValue(), panelX + panelW - 80, sy, accentColor, false);
                } else if (s instanceof ColorSetting) {
                    context.drawText(textRenderer, "RGB", panelX + panelW - 40, sy, 0xFFFFFFFF, false);
                }
                sy += 18;
            }
        }

        // Footer tip
        context.drawText(textRenderer, "ЛКМ — вкл/выкл  |  ПКМ — настройки  |  Right Shift — закрыть", contentX, this.height - 16, 0xFF666666, false);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int leftW = 140;

        // Category click
        if (mouseX < leftW) {
            int y = 50;
            for (Category cat : Category.values()) {
                if (mouseY >= y && mouseY <= y + 22) {
                    selectedCategory = cat;
                    expandedModule = null;
                    searchQuery = "";
                    return true;
                }
                y += 26;
            }
        }

        // Module cards
        ModuleManager mm = BrigClient.getInstance().getModuleManager();
        List<Module> modules = searchQuery.isEmpty()
                ? mm.getModulesByCategory(selectedCategory)
                : mm.search(searchQuery);

        int contentX = leftW + 12;
        int contentY = 48;
        int contentW = this.width - leftW - 24;
        int cardW = 180;
        int cardH = 36;
        int gap = 8;
        int cols = Math.max(1, contentW / (cardW + gap));

        int i = 0;
        for (Module mod : modules) {
            int col = i % cols;
            int row = i / cols;
            int cx = contentX + col * (cardW + gap);
            int cy = contentY + row * (cardH + gap);

            if (mouseX >= cx && mouseX <= cx + cardW && mouseY >= cy && mouseY <= cy + cardH) {
                if (button == 0) { // LMB toggle
                    mod.toggle();
                } else if (button == 1) { // RMB settings
                    expandedModule = (expandedModule == mod) ? null : mod;
                }
                return true;
            }
            i++;
        }

        // Close settings if click outside
        if (button == 1 && expandedModule != null) {
            expandedModule = null;
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE || keyCode == GLFW.GLFW_KEY_RIGHT_SHIFT) {
            this.close();
            return true;
        }
        // Simple search input
        if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !searchQuery.isEmpty()) {
            searchQuery = searchQuery.substring(0, searchQuery.length() - 1);
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (Character.isLetterOrDigit(chr) || chr == ' ' || chr == '-') {
            searchQuery += chr;
            return true;
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
