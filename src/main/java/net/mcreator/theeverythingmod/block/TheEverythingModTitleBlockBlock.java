
package net.mcreator.theeverythingmod.block;

import net.minecraft.block.material.Material;

@TheEverythingModModElements.ModElement.Tag
public class TheEverythingModTitleBlockBlock extends TheEverythingModModElements.ModElement {

	@ObjectHolder("the_everything_mod:the_everything_mod_title_block")
	public static final Block block = null;

	public TheEverythingModTitleBlockBlock(TheEverythingModModElements instance) {
		super(instance, 3);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.PISTON).sound(SoundType.METAL).hardnessAndResistance(-1, 3600000).lightValue(4)
							.doesNotBlockMovement());

			setRegistryName("the_everything_mod_title_block");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Welcome to the everything mod"));
		}

		@Override
		public int tickRate(IWorldReader world) {
			return 5;
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.RED;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand,
				BlockRayTraceResult hit) {
			super.onBlockActivated(state, world, pos, entity, hand, hit);

			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			Direction direction = hit.getFace();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);

				OnRightClickGiveAchievmentProcedure.executeProcedure($_dependencies);
			}

			return ActionResultType.SUCCESS;
		}

	}

}
