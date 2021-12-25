package com.jubiman.mcbammorpg.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronSand extends Block {
	public BlockIronSand() {
		super(FabricBlockSettings
				.of(Material.METAL)
				.strength(0.7F,5.0F)
				.sounds(BlockSoundGroup.SAND)
				.requiresTool()
		);
	}
}
