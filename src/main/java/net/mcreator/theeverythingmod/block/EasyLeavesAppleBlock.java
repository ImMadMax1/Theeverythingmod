
package net.mcreator.theeverythingmod.block;

import net.minecraft.block.material.Material;

@TheEverythingModModElements.ModElement.Tag
public class EasyLeavesAppleBlock extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:easy_leaves_apple")
	public static final Block block = null;

	public EasyLeavesAppleBlock(TheEverythingModModElements instance) {
		super(instance, 14);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(EverythingmodItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.15f, 0f).lightValue(0).notSolid());

			setRegistryName("easy_leaves_apple");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Items.APPLE, (int) (2)));
		}

	}

}
