package ru.brigclient.module.impl.optimization;

import ru.brigclient.module.Category;
import ru.brigclient.module.Module;
import ru.brigclient.module.setting.BooleanSetting;

public class NoRender extends Module {

    public final BooleanSetting noExplosions = addSetting(new BooleanSetting("No Explosions", "Частицы взрывов", true));
    public final BooleanSetting noSmoke = addSetting(new BooleanSetting("No Smoke", "Дым", true));
    public final BooleanSetting noPortal = addSetting(new BooleanSetting("No Portal", "Портальные частицы", false));
    public final BooleanSetting noPotion = addSetting(new BooleanSetting("No Potion Particles", "Частицы зелий", false));
    public final BooleanSetting noCrits = addSetting(new BooleanSetting("No Crits", "Крит-частицы", false));
    public final BooleanSetting lowFire = addSetting(new BooleanSetting("Low Fire", "Низкий огонь на экране", true));
    public final BooleanSetting noWitherHearts = addSetting(new BooleanSetting("No Wither Hearts", "Без потемнения сердец от иссушения", true));
    public final BooleanSetting noHurtCam = addSetting(new BooleanSetting("No Hurt Cam", "Без тряски камеры при уроне", true));

    public NoRender() {
        super("NoRender", "Гибкое отключение лишних эффектов и частиц", Category.OPTIMIZATION);
    }
}
