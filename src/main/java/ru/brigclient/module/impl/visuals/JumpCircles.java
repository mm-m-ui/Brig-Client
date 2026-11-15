package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ColorSetting;
import ru.brigclient.module.setting.NumberSetting;

public class JumpCircles extends Module {

    public final ColorSetting color = addSetting(new ColorSetting("Color", "Цвет кругов", 0xFF00FFFF));
    public final NumberSetting duration = addSetting(new NumberSetting("Duration", "Длительность (сек)", 1.2, 0.3, 3.0, 0.1));

    public JumpCircles() {
        super("Jump Circles", "Расходящиеся неоновые круги при прыжке", Category.VISUALS);
    }
}
