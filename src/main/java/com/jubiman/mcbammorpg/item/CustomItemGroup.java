package com.jubiman.mcbammorpg.item;

import com.jubiman.mcbammorpg.block.CustomBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CustomItemGroup {
	public static ItemGroup WEAPONS = FabricItemGroupBuilder.create(
			new Identifier("mcbammorpg", "weapons"))
			.icon(() -> new ItemStack(CustomItems.ONIMARU_KUNITSUNA))
			.build();
	public static ItemGroup MATERIALS = FabricItemGroupBuilder.create(
					new Identifier("mcbammorpg", "materials"))
			.icon(() -> new ItemStack(CustomItems.TAMAHAGANE_INGOT))
			.build();
	public static ItemGroup FUNCTIONAL_BLOCKS = FabricItemGroupBuilder.create(
					new Identifier("mcbammorpg", "functional"))
			.icon(() -> new ItemStack(CustomBlocks.TATARA))
			.build();
}
