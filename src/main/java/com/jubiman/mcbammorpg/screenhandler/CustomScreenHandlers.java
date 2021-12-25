package com.jubiman.mcbammorpg.screenhandler;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CustomScreenHandlers {
	public static final ScreenHandlerType<TataraScreenHandler> TATARA_SCREEN_HANDLER;

	static {
		TATARA_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("mcbammorpg", "tatara_screen"), TataraScreenHandler::new);
	}
}
