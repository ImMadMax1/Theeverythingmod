
package net.mcreator.theeverythingmod.item;

@TheEverythingModModElements.ModElement.Tag
public class VioletoreHoeItem extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:violetore_hoe")
	public static final Item block = null;

	public VioletoreHoeItem(TheEverythingModModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 6280;
			}

			public float getEfficiency() {
				return 24f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 20;
			}

			public int getEnchantability() {
				return 140;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("violetore_hoe"));
	}

}
