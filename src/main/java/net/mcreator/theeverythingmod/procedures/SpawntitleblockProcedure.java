package net.mcreator.theeverythingmod.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.theeverythingmod.block.TheEverythingModTitleBlockBlock;
import net.mcreator.theeverythingmod.TheEverythingModModElements;

@TheEverythingModModElements.ModElement.Tag
public class SpawntitleblockProcedure extends TheEverythingModModElements.ModElement {
	public SpawntitleblockProcedure(TheEverythingModModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Spawntitleblock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Spawntitleblock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Spawntitleblock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Spawntitleblock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), TheEverythingModTitleBlockBlock.block.getDefaultState(), 3);
	}
}
