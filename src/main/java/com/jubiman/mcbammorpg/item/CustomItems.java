package com.jubiman.mcbammorpg.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Rarity;

public class CustomItems {
	// Ingots
	public static final Item AKAME_SATETSU;
	public static final Item MASA_SATETSU;
	public static final Item TAMAHAGANE_INGOT;

	// Swords
	public static final SwordItem ONIMARU_KUNITSUNA;

	static {
		// Ingots
		AKAME_SATETSU = new Item(new FabricItemSettings().group(CustomItemGroup.MATERIALS).rarity(Rarity.UNCOMMON));
		MASA_SATETSU = new Item(new FabricItemSettings().group(CustomItemGroup.MATERIALS).rarity(Rarity.RARE));
		TAMAHAGANE_INGOT = new Item(new FabricItemSettings().group(CustomItemGroup.MATERIALS).rarity(Rarity.EPIC));

		// Swords
		ONIMARU_KUNITSUNA = new SwordItem(Materials.TAMAHAGANE, 50, 3.0F, new FabricItemSettings().maxCount(1).maxDamage(3000).rarity(Rarity.EPIC).fireproof().group(CustomItemGroup.WEAPONS));
	}
}
