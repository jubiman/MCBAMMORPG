package com.jubiman.mcbammorpg;

import com.jubiman.mcbammorpg.screen.TataraScreen;
import com.jubiman.mcbammorpg.screenhandler.CustomScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class MCBAMMORPGClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenRegistry.register(CustomScreenHandlers.TATARA_SCREEN_HANDLER, TataraScreen::new);
	}
}
