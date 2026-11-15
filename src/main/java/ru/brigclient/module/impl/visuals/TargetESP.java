package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ColorSetting;
import ru.brigclient.module.setting.NumberSetting;

public class TargetESP extends Module {

    public final ColorSetting color = addSetting(new ColorSetting("Color", "Цвет подсветки", 0xFFFF4444));
    public final NumberSetting speed = addSetting(new NumberSetting("Speed", "Скорость вращения", 2.0, 0.5, 5.0, 0.1));
    public final NumberSetting radius = addSetting(new NumberSetting("Radius", "Радиус кольца", 0.8, 0.4, 1.5, 0.05));

    public TargetESP() {
        super("Target ESP", "Анимированная 3D-подсветка цели (кольцо/аура)", Category.VISUALS);
    }
}
