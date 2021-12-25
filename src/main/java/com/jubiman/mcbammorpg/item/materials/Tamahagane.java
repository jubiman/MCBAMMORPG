package com.jubiman.mcbammorpg.item.materials;

import com.jubiman.mcbammorpg.item.CustomItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Tamahagane implements ToolMaterial {
	@Override
	public int getDurability() {
		return 3000;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 10.0F;
	}

	@Override
	public float getAttackDamage() {
		return 5.0F;
	}

	@Override
	public int getMiningLevel() {
		return 5;
	}

	@Override
	public int getEnchantability() {
		return 100;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(CustomItems.TAMAHAGANE_INGOT);
	}
}
