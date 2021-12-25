package com.jubiman.mcbammorpg.block;

import com.jubiman.mcbammorpg.blockentity.BlockEntityTatara;
import com.jubiman.mcbammorpg.blockentity.CustomBlockEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BlockTatara extends BlockWithEntity implements BlockEntityProvider {
	public BlockTatara() {
		super(FabricBlockSettings
						.of(Material.METAL)
						.strength(3.F,6.0F)
						.sounds(BlockSoundGroup.METAL)
						.requiresTool()
		);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new BlockEntityTatara(pos, state);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return checkType(type, CustomBlockEntities.BLOCK_ENTITY_TATARA, BlockEntityTatara::tick);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			//This will call the createScreenHandlerFactory method from BlockWithEntity, which will return our blockEntity casted to
			//a namedScreenHandlerFactory. If your block class does not extend BlockWithEntity, it needs to implement createScreenHandlerFactory.
			NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

			if (screenHandlerFactory != null) {
				//With this call the server will request the client to open the appropriate Screenhandler
				player.openHandledScreen(screenHandlerFactory);
			}
		}
		return ActionResult.SUCCESS;
	}

	@Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof BlockEntityTatara) {
			ItemScatterer.spawn(world, pos, (BlockEntityTatara) blockEntity);
			// update comparators
			world.updateComparators(pos, this);
		}
		super.onBreak(world, pos, state, player);
	}

	@Override
	public boolean shouldDropItemsOnExplosion(Explosion explosion) {
		return true;
	}
}
