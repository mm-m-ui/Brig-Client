package ru.brigclient.module.impl.cosmetics;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ModeSetting;

public class Capes extends Module {

    public final ModeSetting cape = addSetting(new ModeSetting("Cape", "Выбор плаща", "Crown", 
            "Crown", "Galaxy", "Nebula", "Fire", "Ice"));

    public Capes() {
        super("Capes", "5 кастомных плащей высокого разрешения", Category.COSMETICS);
    }
}
