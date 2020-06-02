package net.mcreator.theeverythingmod.procedures;

@TheEverythingModModElements.ModElement.Tag
public class MountainDewFoodEatenProcedure extends TheEverythingModModElements.ModElement {

	public MountainDewFoodEatenProcedure(TheEverythingModModElements instance) {
		super(instance, 10);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MountainDewFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 180, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 60, (int) 3));

	}

}
