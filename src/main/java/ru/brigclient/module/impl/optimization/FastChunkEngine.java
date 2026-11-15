package ru.brigclient.module.impl.optimization;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;
import ru.brigclient.module.setting.NumberSetting;

public class FastChunkEngine extends Module {

    public final BooleanSetting cullInvisible = addSetting(new BooleanSetting("Cull Invisible Entities", "Отсечение сущностей за стенами", true));
    public final BooleanSetting optimizeLeaves = addSetting(new BooleanSetting("Optimize Leaves", "Оптимизация листвы", true));
    public final NumberSetting renderDistanceBoost = addSetting(new NumberSetting("Chunk Priority", "Приоритет прогрузки", 1.0, 0.5, 2.0, 0.1));

    public FastChunkEngine() {
        super("Fast Chunk & Block Engine", "Оптимизация прогрузки чанков и сложных блоков", Category.OPTIMIZATION);
    }
}
