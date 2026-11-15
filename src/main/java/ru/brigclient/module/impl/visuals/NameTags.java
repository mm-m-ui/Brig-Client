package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;

public class NameTags extends Module {

    public final BooleanSetting showSelf = addSetting(new BooleanSetting("Show Self", "Показывать свой ник в 3-м лице", true));
    public final BooleanSetting showHealth = addSetting(new BooleanSetting("Show Health", "Показывать HP", true));
    public final BooleanSetting showArmor = addSetting(new BooleanSetting("Show Armor", "Показывать броню", true));

    public NameTags() {
        super("NameTags", "Ники игроков с HP и бронёй", Category.VISUALS);
    }
}
