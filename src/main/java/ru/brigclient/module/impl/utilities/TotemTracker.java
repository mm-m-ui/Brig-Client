package ru.brigclient.module.impl.utilities;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;

public class TotemTracker extends Module {

    public final BooleanSetting showCount = addSetting(new BooleanSetting("Show Count", "Счётчик тотемов", true));
    public final BooleanSetting notifySelf = addSetting(new BooleanSetting("Notify Self", "Уведомление при срабатывании у себя", true));
    public final BooleanSetting notifyNearby = addSetting(new BooleanSetting("Notify Nearby", "Уведомление рядом", true));
    public final BooleanSetting sound = addSetting(new BooleanSetting("Sound", "Звуковое уведомление", true));

    public TotemTracker() {
        super("Totem Tracker", "Счётчик тотемов и уведомления о срабатывании", Category.UTILITIES);
    }
}
