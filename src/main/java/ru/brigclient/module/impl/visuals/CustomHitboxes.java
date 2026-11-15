package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ColorSetting;
import ru.brigclient.module.setting.ModeSetting;

public class CustomHitboxes extends Module {

    public final ModeSetting style = addSetting(new ModeSetting("Style", "Стиль", "Lines", "Lines", "Filled", "Corners"));
    public final ColorSetting color = addSetting(new ColorSetting("Color", "Цвет", 0xAAFFFFFF));

    public CustomHitboxes() {
        super("Custom Hitboxes", "Кастомные 3D-хитбоксы сущностей", Category.VISUALS);
    }
}
