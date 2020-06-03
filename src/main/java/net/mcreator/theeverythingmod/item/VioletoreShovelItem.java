
package net.mcreator.theeverythingmod.item;

@TheEverythingModModElements.ModElement.Tag
public class VioletoreShovelItem extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:violetore_shovel")
	public static final Item block = null;

	public VioletoreShovelItem(TheEverythingModModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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

		}.setRegistryName("violetore_shovel"));
	}

}
