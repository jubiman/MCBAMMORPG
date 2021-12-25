package com.jubiman.mcbammorpg.block;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BlockTags {
	public static final Tag<Block> IRON_SAND;

	static {
		IRON_SAND = TagFactory.BLOCK.create(new Identifier("mcbammorpg", "iron_sand"));
	}
}
