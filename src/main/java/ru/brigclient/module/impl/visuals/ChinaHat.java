package ru.brigclient.module.impl.visuals;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.ColorSetting;
import ru.brigclient.module.setting.NumberSetting;

public class ChinaHat extends Module {

    public final NumberSetting radius = addSetting(new NumberSetting("Radius", "Радиус", 0.7, 0.3, 1.5, 0.05));
    public final NumberSetting height = addSetting(new NumberSetting("Height", "Высота", 0.35, 0.1, 1.0, 0.05));
    public final NumberSetting opacity = addSetting(new NumberSetting("Opacity", "Прозрачность", 0.7, 0.1, 1.0, 0.05));
    public final ColorSetting color1 = addSetting(new ColorSetting("Color 1", "Основной цвет", 0xFF00FFAA));
    public final ColorSetting color2 = addSetting(new ColorSetting("Color 2", "Акцент", 0xFFAA00FF));

    public ChinaHat() {
        super("China Hat", "Красивый 3D-конус над головой игрока", Category.VISUALS);
    }

    @Override
    public void onRender3D(float tickDelta) {
        // Rendered via custom WorldRenderEvents or mixin into player renderer
    }
}
