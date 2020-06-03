
package net.mcreator.theeverythingmod.item;

@TheEverythingModModElements.ModElement.Tag
public class MetalIngotItem extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:metal_ingot")
	public static final Item block = null;

	public MetalIngotItem(TheEverythingModModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(EverythingmodItemGroup.tab).maxStackSize(64));
			setRegistryName("metal_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("can be used to craft sturdier items"));
		}

	}

}
