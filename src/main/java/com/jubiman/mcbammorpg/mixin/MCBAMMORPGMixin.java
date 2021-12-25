package com.jubiman.mcbammorpg.mixin;

import com.jubiman.mcbammorpg.MCBAMMORPG;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MCBAMMORPGMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo cbi) {
		MCBAMMORPG.LOGGER.info("A message from a random mixin, lol");
	}
}
