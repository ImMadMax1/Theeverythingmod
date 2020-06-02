
package net.mcreator.theeverythingmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.theeverythingmod.block.TheEverythingModTitleBlockBlock;
import net.mcreator.theeverythingmod.TheEverythingModModElements;

@TheEverythingModModElements.ModElement.Tag
public class EverythingmodItemGroup extends TheEverythingModModElements.ModElement {
	public EverythingmodItemGroup(TheEverythingModModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabeverythingmod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TheEverythingModTitleBlockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
