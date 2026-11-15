package ru.brigclient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import ru.brigclient.gui.clickgui.ClickGuiScreen;
import ru.brigclient.module.ModuleManager;
import ru.brigclient.render.HudRenderer;
import ru.brigclient.util.ColorUtil;

/**
 * Brig Client - Modular utility client for Minecraft 1.21.11
 * Entry point.
 */
public class BrigClient implements ClientModInitializer {

    public static final String MOD_ID = "brigclient";
    public static final String NAME = "Brig Client";
    public static final String VERSION = "1.0.0";

    public static BrigClient INSTANCE;
    public static MinecraftClient mc;

    private ModuleManager moduleManager;
    private KeyBinding clickGuiKey;
    private ClickGuiScreen clickGui;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        mc = MinecraftClient.getInstance();

        // Module system
        moduleManager = new ModuleManager();
        moduleManager.init();

        // KeyBinding Category for 1.21.11
        KeyBinding.Category category = KeyBinding.Category.create(Identifier.of(MOD_ID, "main"));

        clickGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.brigclient.clickgui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                category
        ));

        // Tick for keybinds and modules
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            while (clickGuiKey.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(getClickGui());
                } else if (client.currentScreen instanceof ClickGuiScreen) {
                    client.setScreen(null);
                }
            }

            moduleManager.onTick();
        });

        // HUD render
        HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {
            if (mc.player != null && !mc.options.hudHidden) {
                HudRenderer.render(drawContext, tickCounter.getTickDelta(false));
            }
        });

        System.out.println("[BrigClient] Initialized successfully. Version " + VERSION);
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public ClickGuiScreen getClickGui() {
        if (clickGui == null) {
            clickGui = new ClickGuiScreen();
        }
        return clickGui;
    }

    public static BrigClient getInstance() {
        return INSTANCE;
    }
}
