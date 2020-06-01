package net.mcreator.theeverythingmod.procedures;

@TheEverythingModModElements.ModElement.Tag
public class OnRightClickGiveAchievmentProcedure extends TheEverythingModModElements.ModElement {

	public OnRightClickGiveAchievmentProcedure(TheEverythingModModElements instance) {
		super(instance, 4);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnRightClickGiveAchievment!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("the_everything_mod:enterworld"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}

	}

}