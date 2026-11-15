package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;
import ru.brigclient.module.setting.NumberSetting;

public class ViewModel extends Module {

    public final NumberSetting posX = addSetting(new NumberSetting("Pos X", "Позиция X", 0.0, -2.0, 2.0, 0.05));
    public final NumberSetting posY = addSetting(new NumberSetting("Pos Y", "Позиция Y", 0.0, -2.0, 2.0, 0.05));
    public final NumberSetting posZ = addSetting(new NumberSetting("Pos Z", "Позиция Z", 0.0, -2.0, 2.0, 0.05));
    public final NumberSetting scale = addSetting(new NumberSetting("Scale", "Масштаб", 1.0, 0.1, 2.0, 0.05));
    public final BooleanSetting mirror = addSetting(new BooleanSetting("Mirror", "Зеркало", false));

    public ViewModel() {
        super("ViewModel", "Настройка положения рук и предметов от 1-го лица", Category.VISUALS);
    }
}
