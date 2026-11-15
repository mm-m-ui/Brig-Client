package ru.brigclient.module.impl.hud;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;

public class CooldownsHUD extends Module {

    public final BooleanSetting enderPearl = addSetting(new BooleanSetting("Ender Pearl", "Эндер-перл", true));
    public final BooleanSetting goldenApple = addSetting(new BooleanSetting("Golden Apple", "Золотое яблоко", true));
    public final BooleanSetting chorus = addSetting(new BooleanSetting("Chorus", "Хорус", true));
    public final BooleanSetting shield = addSetting(new BooleanSetting("Shield", "Щит", true));

    public CooldownsHUD() {
        super("Cooldowns HUD", "Таймеры перезарядки PvP-предметов", Category.HUD);
    }
}
