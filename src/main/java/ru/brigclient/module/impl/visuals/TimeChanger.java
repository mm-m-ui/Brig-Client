package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ModeSetting;
import ru.brigclient.module.setting.NumberSetting;

public class TimeChanger extends Module {

    public final ModeSetting mode = addSetting(new ModeSetting("Mode", "Режим времени", "Slider", "Day", "Noon", "Sunset", "Night", "Slider"));
    public final NumberSetting time = addSetting(new NumberSetting("Time", "Время (0-24000)", 6000, 0, 24000, 100));

    public TimeChanger() {
        super("Time Changer", "Визуальная смена времени суток для клиента", Category.VISUALS);
    }
}
