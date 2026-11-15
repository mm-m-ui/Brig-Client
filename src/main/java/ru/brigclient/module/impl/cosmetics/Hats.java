package ru.brigclient.module.impl.cosmetics;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ModeSetting;

public class Hats extends Module {

    public final ModeSetting hat = addSetting(new ModeSetting("Hat", "Выбор шляпы", "Crown", 
            "Crown", "Horns", "Halo", "Ears", "TopHat"));

    public Hats() {
        super("Hats", "5 видов 3D-шляп: корона, рожки, нимб, ушки, цилиндр", Category.COSMETICS);
    }
}
