
package net.mcreator.theeverythingmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.theeverythingmod.itemgroup.EverythingmodItemGroup;
import net.mcreator.theeverythingmod.TheEverythingModModElements;

@TheEverythingModModElements.ModElement.Tag
public class MetalSwordItem extends TheEverythingModModElements.ModElement {
	@ObjectHolder("the_everything_mod:metal_sword")
	public static final Item block = null;
	public MetalSwordItem(TheEverythingModModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 1.4f;
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
		}, 3, -3f, new Item.Properties().group(EverythingmodItemGroup.tab)) {
		}.setRegistryName("metal_sword"));
	}
}
