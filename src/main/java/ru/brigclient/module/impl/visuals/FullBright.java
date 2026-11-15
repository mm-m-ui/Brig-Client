package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.NumberSetting;

public class FullBright extends Module {

    public final NumberSetting gamma = addSetting(new NumberSetting("Gamma", "Уровень яркости", 16.0, 1.0, 16.0, 0.5));

    public FullBright() {
        super("FullBright", "Максимальная яркость — осветляет пещеры и ночь", Category.VISUALS);
    }

    // Actual gamma override is done via LightmapTextureManagerMixin
}
