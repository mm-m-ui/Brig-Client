package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.NumberSetting;

public class SeeInvisible extends Module {

    public final NumberSetting opacity = addSetting(new NumberSetting("Opacity", "Прозрачность призраков", 0.4, 0.1, 0.9, 0.05));

    public SeeInvisible() {
        super("See Invisible", "Невидимые игроки/сущности становятся полупрозрачными", Category.VISUALS);
    }
}
