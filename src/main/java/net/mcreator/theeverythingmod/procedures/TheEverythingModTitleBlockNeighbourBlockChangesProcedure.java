package net.mcreator.theeverythingmod.procedures;

@TheEverythingModModElements.ModElement.Tag
public class TheEverythingModTitleBlockNeighbourBlockChangesProcedure extends TheEverythingModModElements.ModElement {

	public TheEverythingModTitleBlockNeighbourBlockChangesProcedure(TheEverythingModModElements instance) {
		super(instance, 3);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TheEverythingModTitleBlockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TheEverythingModTitleBlockNeighbourBlockChanges!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");

		if (world instanceof ServerWorld)
			((ServerWorld) world).addLightningBolt(
					new LightningBoltEntity(world, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), false));

	}

}
