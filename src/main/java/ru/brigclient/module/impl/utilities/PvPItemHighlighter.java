package ru.brigclient.module.impl.utilities;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;

public class PvPItemHighlighter extends Module {

    public final BooleanSetting swords = addSetting(new BooleanSetting("Swords", "Алмазные/незеритовые мечи", true));
    public final BooleanSetting gapples = addSetting(new BooleanSetting("Golden Apples", "Золотые яблоки", true));
    public final BooleanSetting pearls = addSetting(new BooleanSetting("Ender Pearls", "Эндер-перлы", true));
    public final BooleanSetting chorus = addSetting(new BooleanSetting("Chorus Fruit", "Плоды хоруса", true));
    public final BooleanSetting totems = addSetting(new BooleanSetting("Totems", "Тотемы", true));
    public final BooleanSetting crystals = addSetting(new BooleanSetting("Crystals", "Кристаллы", true));

    public PvPItemHighlighter() {
        super("PvP Item Highlighter", "Подсветка важных PvP-предметов на земле", Category.UTILITIES);
    }
}
