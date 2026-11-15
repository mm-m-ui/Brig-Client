package ru.brigclient.module.impl.hud;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ColorSetting;
import ru.brigclient.module.setting.ModeSetting;
import ru.brigclient.module.setting.NumberSetting;

public class CustomCrosshair extends Module {

    public final ModeSetting style = addSetting(new ModeSetting("Style", "Стиль", "Cross", "Cross", "Circle"));
    public final ColorSetting color = addSetting(new ColorSetting("Color", "Цвет", 0xFFFFFFFF));
    public final NumberSetting size = addSetting(new NumberSetting("Size", "Размер", 6, 2, 20, 1));

    public CustomCrosshair() {
        super("Custom Crosshair", "Кастомный прицел (крест / круг)", Category.HUD);
    }
}
