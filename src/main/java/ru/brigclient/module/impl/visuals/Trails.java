package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ColorSetting;
import ru.brigclient.module.setting.NumberSetting;

public class Trails extends Module {

    public final NumberSetting length = addSetting(new NumberSetting("Length", "Длина следа", 20, 5, 60, 1));
    public final ColorSetting colorStart = addSetting(new ColorSetting("Start Color", "Начало градиента", 0xFF00FFAA));
    public final ColorSetting colorEnd = addSetting(new ColorSetting("End Color", "Конец градиента", 0x0000FFAA));

    public Trails() {
        super("Trails", "Светящийся шлейф за игроком", Category.VISUALS);
    }
}
