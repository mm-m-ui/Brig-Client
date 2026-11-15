package ru.brigclient.module.impl.optimization;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;

public class PotatoMode extends Module {

    public final BooleanSetting flatTextures = addSetting(new BooleanSetting("Flat Textures", "Упрощённые 1x1 текстуры блоков", true));
    public final BooleanSetting noEntityShadows = addSetting(new BooleanSetting("No Entity Shadows", "Отключить тени сущностей", true));
    public final BooleanSetting noSmoothing = addSetting(new BooleanSetting("No Smoothing", "Отключить сглаживание", true));

    public PotatoMode() {
        super("Potato Mode", "Максимальная оптимизация для слабых ПК — плоские текстуры, без теней", Category.OPTIMIZATION);
    }

    @Override
    protected void onEnable() {
        // Actual texture simplification requires resource pack or mixin into TextureManager / BakedModel.
        // Stub: flag is used by mixins / render hooks.
    }
}
