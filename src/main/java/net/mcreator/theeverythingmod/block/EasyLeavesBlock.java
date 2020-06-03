
package net.mcreator.theeverythingmod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.theeverythingmod.itemgroup.EverythingmodItemGroup;
import net.mcreator.theeverythingmod.TheEverythingModModElements;

import java.util.List;
import java.util.Collections;

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
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.1f, 1f).lightValue(0));
			setRegistryName("easy_leaves");
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
