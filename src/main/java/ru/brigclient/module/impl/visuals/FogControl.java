package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;
import ru.brigclient.module.setting.ColorSetting;

public class FogControl extends Module {

    public final BooleanSetting disableFog = addSetting(new BooleanSetting("Disable Fog", "Полностью отключить туман", false));
    public final ColorSetting fogColor = addSetting(new ColorSetting("Fog Color", "Цвет тумана", 0xFF88AADD));

    public FogControl() {
        super("Fog Control", "Отключение или перекраска тумана", Category.VISUALS);
    }
}
