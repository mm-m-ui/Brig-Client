package ru.brigclient.module.impl.hud;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;

public class TargetHUD extends Module {

    public final BooleanSetting showArmor = addSetting(new BooleanSetting("Show Armor", "Показывать броню", true));
    public final BooleanSetting animatedHp = addSetting(new BooleanSetting("Animated HP", "Плавная анимация HP", true));

    public TargetHUD() {
        super("Target HUD", "Карточка цели в бою (скин, ник, HP, броня)", Category.HUD);
    }
}
