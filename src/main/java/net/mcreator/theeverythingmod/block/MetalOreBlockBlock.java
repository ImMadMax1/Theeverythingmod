
package net.mcreator.theeverythingmod.block;

import net.minecraft.block.material.Material;

@TheEverythingModModElements.ModElement.Tag
public class MetalOreBlockBlock extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:metal_ore_block")
	public static final Block block = null;

	public MetalOreBlockBlock(TheEverythingModModElements instance) {
		super(instance, 21);

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

					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.6f, 10f).lightValue(0).harvestLevel(3)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("metal_ore_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
