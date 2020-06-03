
package net.mcreator.theeverythingmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.theeverythingmod.itemgroup.EverythingmodItemGroup;
import net.mcreator.theeverythingmod.TheEverythingModModElements;

@TheEverythingModModElements.ModElement.Tag
public class MetalHoeItem extends TheEverythingModModElements.ModElement {
	@ObjectHolder("the_everything_mod:metal_hoe")
	public static final Item block = null;
	public MetalHoeItem(TheEverythingModModElements instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 18;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, -3f, new Item.Properties().group(EverythingmodItemGroup.tab)) {
		}.setRegistryName("metal_hoe"));
	}
}
