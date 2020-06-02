package net.mcreator.theeverythingmod.procedures;

@TheEverythingModModElements.ModElement.Tag
public class MusicboxOnBlockRightClickedProcedure extends TheEverythingModModElements.ModElement {

	public MusicboxOnBlockRightClickedProcedure(TheEverythingModModElements instance) {
		super(instance, 5);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MusicboxOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MusicboxOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MusicboxOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MusicboxOnBlockRightClicked!");
			return;
		}

		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		world.playSound((PlayerEntity) null, x, y, z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_everything_mod:dragoneatingspastic")),
				SoundCategory.NEUTRAL, (float) 4, (float) 1);

	}

}
