package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ModeSetting;
import ru.brigclient.module.setting.NumberSetting;

public class CustomSky extends Module {

    public final ModeSetting mode = addSetting(new ModeSetting("Mode", "Вариант неба", "Galaxy", "Galaxy", "Nebula", "Night Cosmos", "Default"));
    public final NumberSetting opacity = addSetting(new NumberSetting("Opacity", "Прозрачность", 1.0, 0.3, 1.0, 0.05));

    public CustomSky() {
        super("Custom Sky & Nebula", "Кастомное небо: Галактика / Небула / Космос", Category.VISUALS);
    }
}
