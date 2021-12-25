package com.jubiman.mcbammorpg;

import com.jubiman.mcbammorpg.block.CustomBlocks;
import com.jubiman.mcbammorpg.blockentity.BlockEntityTatara;
import com.jubiman.mcbammorpg.blockentity.CustomBlockEntities;
import com.jubiman.mcbammorpg.item.CustomItemGroup;
import com.jubiman.mcbammorpg.item.CustomItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MCBAMMORPG implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("MCBAMMORPG");

	@Override
	public void onInitialize() {
		LOGGER.info("Registering mod items...");
		registerAll();
		LOGGER.info("Finished registering mod items.");

		LOGGER.info("Finished initializing Minecraft, but an MMORPG. (Just forget about the it's, lol)");
	}

	private void registerAll() {
		LOGGER.info("Registering items...");
		Registry.register(Registry.ITEM, new Identifier("mcbammorpg", "tamahagane_ingot"), CustomItems.TAMAHAGANE_INGOT);
		Registry.register(Registry.ITEM, new Identifier("mcbammorpg", "onimaru_kunitsuna"), CustomItems.ONIMARU_KUNITSUNA);
		LOGGER.info("Finished registering items.");

		LOGGER.info("Registering blocks and their items...");
		Registry.register(Registry.BLOCK, new Identifier("mcbammorpg", "iron_sand"), CustomBlocks.IRON_SAND);
		Registry.register(Registry.ITEM, new Identifier("mcbammorpg", "iron_sand"), new BlockItem(CustomBlocks.IRON_SAND, new FabricItemSettings().group(CustomItemGroup.MATERIALS)));
		Registry.register(Registry.BLOCK, new Identifier("mcbammorpg", "tatara"), CustomBlocks.TATARA);
		Registry.register(Registry.ITEM, new Identifier("mcbammorpg", "tatara"), new BlockItem(CustomBlocks.TATARA, new FabricItemSettings().group(CustomItemGroup.FUNCTIONAL_BLOCKS)));
		LOGGER.info("Finished registering blocks.");

		LOGGER.info("Registering block entities...");
		CustomBlockEntities.BLOCK_ENTITY_TATARA = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("mcbammorpg", "tatara"), FabricBlockEntityTypeBuilder.create(BlockEntityTatara::new, CustomBlocks.TATARA).build(null));
		LOGGER.info("Finished registering block entities.");//BlockEntityTatara::new, CustomBlockEntities.BLOCK_ENTITY_TATARA
	}
}
