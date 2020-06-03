
package net.mcreator.theeverythingmod.item;

@TheEverythingModModElements.ModElement.Tag
public class VioletoreAxeItem extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:violetore_axe")
	public static final Item block = null;

	public VioletoreAxeItem(TheEverythingModModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("violetore_axe"));
	}

}
