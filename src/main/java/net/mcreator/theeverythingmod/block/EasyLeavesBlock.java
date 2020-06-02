
package net.mcreator.theeverythingmod.block;

import net.minecraft.block.material.Material;

@TheEverythingModModElements.ModElement.Tag
public class EasyLeavesBlock extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:easy_leaves")
	public static final Block block = null;

	public EasyLeavesBlock(TheEverythingModModElements instance) {
		super(instance, 13);

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

					Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.1f, 1f).lightValue(0).notSolid());

			setRegistryName("easy_leaves");
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
			return Collections.singletonList(new ItemStack(Blocks.DARK_OAK_SAPLING, (int) (2)));
		}

	}

}
