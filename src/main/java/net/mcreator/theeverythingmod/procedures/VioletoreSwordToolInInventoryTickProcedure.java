package net.mcreator.theeverythingmod.procedures;

@TheEverythingModModElements.ModElement.Tag
public class VioletoreSwordToolInInventoryTickProcedure extends TheEverythingModModElements.ModElement {

	public VioletoreSwordToolInInventoryTickProcedure(TheEverythingModModElements instance) {
		super(instance, 52);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VioletoreSwordToolInInventoryTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 60, (int) 3));

	}

}
