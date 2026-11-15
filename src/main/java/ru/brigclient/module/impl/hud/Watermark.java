package ru.brigclient.module.impl.hud;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;
import ru.brigclient.module.setting.ColorSetting;

public class Watermark extends Module {

    public final BooleanSetting showFps = addSetting(new BooleanSetting("Show FPS", "Показывать FPS", true));
    public final BooleanSetting showPing = addSetting(new BooleanSetting("Show Ping", "Показывать пинг", true));
    public final BooleanSetting showName = addSetting(new BooleanSetting("Show Name", "Показывать ник", true));
    public final ColorSetting color = addSetting(new ColorSetting("Accent", "Акцентный цвет", 0xFF00FFAA));

    public Watermark() {
        super("Watermark", "Плашка с логотипом, FPS, пингом и ником", Category.HUD);
        setEnabled(true);
    }
}
