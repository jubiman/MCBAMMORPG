package com.jubiman.mcbammorpg.blockentity;

import com.jubiman.mcbammorpg.screenhandler.TataraScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEntityTatara extends BlockEntity implements SimpleItemStackHandler, NamedScreenHandlerFactory {
	public int furnaceBurnTime;
	public int currentItemBurnTime;
	public int cookTime;
	public int totalCookTime;
	public DefaultedList<ItemStack> inventory;

	public BlockEntityTatara(BlockPos pos, BlockState state) {
		super(CustomBlockEntities.BLOCK_ENTITY_TATARA, pos, state);
	}

	public static void tick(World world, BlockPos pos, BlockState state, BlockEntityTatara be) {

	}


	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		//We provide *this* to the screenHandler as our class Implements Inventory
		//Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
		return new TataraScreenHandler(syncId, playerInventory, this);
	}

	public static int getItemBurnTime(ItemStack stack) {
		if(!stack.isEmpty()) {
			// if(stack.isItemEqual(new ItemStack()))
			return 1600;
		}

		return 0;
	}

	@Override
	public void writeNbt(NbtCompound tag) {
		super.writeNbt(tag);

		tag.putInt("BurnTime", this.furnaceBurnTime);
		tag.putInt("CookTime", this.cookTime);
		tag.putInt("CookTimeTotal", this.totalCookTime);
	}

	@Override
	public void readNbt(NbtCompound tag) {
		super.readNbt(tag);
		inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
		Inventories.readNbt(tag, inventory);

		this.furnaceBurnTime = tag.getInt("BurnTime");
		this.cookTime = tag.getInt("CookTime");
		this.totalCookTime = tag.getInt("CookTimeTotal");
		this.currentItemBurnTime = getItemBurnTime(getStack(1));
	}

	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}

	@Override
	public Text getDisplayName() {
		return null;
	}
}
