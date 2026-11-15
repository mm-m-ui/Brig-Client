package ru.brigclient.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import ru.brigclient.BrigClient;
import ru.brigclient.module.ModuleManager;
import ru.brigclient.module.impl.hud.Watermark;
import ru.brigclient.util.ColorUtil;

public final class HudRenderer {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    private HudRenderer() {}

    public static void render(DrawContext context, float tickDelta) {
        ModuleManager mm = BrigClient.getInstance().getModuleManager();
        mm.onRender2D(tickDelta);

        // Simple watermark if enabled
        Watermark wm = (Watermark) mm.getModuleByName("Watermark");
        if (wm != null && wm.isEnabled()) {
            int x = 6;
            int y = 6;
            int accent = wm.color.getValue();
            String text = "Brig Client";
            if (wm.showFps.getValue()) {
                text += "  |  " + mc.getCurrentFps() + " FPS";
            }
            if (wm.showPing.getValue() && mc.getNetworkHandler() != null && mc.player != null) {
                var entry = mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid());
                int ping = entry != null ? entry.getLatency() : 0;
                text += "  |  " + ping + " ms";
            }
            if (wm.showName.getValue() && mc.player != null) {
                text += "  |  " + mc.player.getName().getString();
            }

            // Background rounded-ish
            int w = mc.textRenderer.getWidth(text) + 12;
            context.fill(x, y, x + w, y + 14, ColorUtil.rgba(20, 20, 25, 180));
            context.drawText(mc.textRenderer, text, x + 6, y + 3, accent, true);
        }
    }
}
