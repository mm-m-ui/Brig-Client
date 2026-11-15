package ru.brigclient.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.brigclient.BrigClient;
import ru.brigclient.module.impl.optimization.NoRender;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "tiltViewWhenHurt", at = @At("HEAD"), cancellable = true)
    private void brigclient$noHurtCam(CallbackInfo ci) {
        if (BrigClient.getInstance() != null) {
            NoRender nr = (NoRender) BrigClient.getInstance().getModuleManager().getModuleByName("NoRender");
            if (nr != null && nr.isEnabled() && nr.noHurtCam.getValue()) {
                ci.cancel();
            }
        }
    }
}
