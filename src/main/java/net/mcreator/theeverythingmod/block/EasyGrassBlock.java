
package net.mcreator.theeverythingmod.block;

import net.minecraft.block.material.Material;

@TheEverythingModModElements.ModElement.Tag
public class EasyGrassBlock extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:easy_grass")
	public static final Block block = null;

	public EasyGrassBlock(TheEverythingModModElements instance) {
		super(instance, 16);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(EverythingmodItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ORGANIC).sound(SoundType.WET_GRASS).hardnessAndResistance(0.15f, 0f).lightValue(0));

			setRegistryName("easy_grass");
		}

		@OnlyIn(Dist.CLIENT)
		public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.GRASS_BLOCK, (int) (1)));
		}

	}

}
