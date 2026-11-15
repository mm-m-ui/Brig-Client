package ru.brigclient.mixin;

import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import ru.brigclient.BrigClient;
import ru.brigclient.module.impl.visuals.FullBright;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {

    @ModifyVariable(method = "update", at = @At("STORE"), ordinal = 0, require = 0)
    private float brigclient$modifyGamma(float gamma) {
        if (BrigClient.getInstance() != null) {
            FullBright fb = (FullBright) BrigClient.getInstance().getModuleManager().getModuleByName("FullBright");
            if (fb != null && fb.isEnabled()) {
                return fb.gamma.getFloat();
            }
        }
        return gamma;
    }
}
