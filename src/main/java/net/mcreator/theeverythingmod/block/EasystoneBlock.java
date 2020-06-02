
package net.mcreator.theeverythingmod.block;

import net.minecraft.block.material.Material;

@TheEverythingModModElements.ModElement.Tag
public class EasystoneBlock extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:easystone")
	public static final Block block = null;

	public EasystoneBlock(TheEverythingModModElements instance) {
		super(instance, 17);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(0.1f, 0f).lightValue(0));

			setRegistryName("easystone");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.COBBLESTONE, (int) (4)));
		}

	}

}
