
package net.mcreator.theeverythingmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.feature.LakesFeature;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.theeverythingmod.procedures.EasyWaterMobplayerCollidesBlockProcedure;
import net.mcreator.theeverythingmod.itemgroup.EverythingmodItemGroup;
import net.mcreator.theeverythingmod.TheEverythingModModElements;

import java.util.Random;

@TheEverythingModModElements.ModElement.Tag
public class EasyWaterBlock extends TheEverythingModModElements.ModElement {
	@ObjectHolder("the_everything_mod:easy_water")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("the_everything_mod:easy_water_bucket")
	public static final Item bucket = null;
	private FlowingFluid flowing = null;
	private FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;
	public EasyWaterBlock(TheEverythingModModElements instance) {
		super(instance, 15);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerFluids(RegistryEvent.Register<Fluid> event) {
		event.getRegistry().register(still);
		event.getRegistry().register(flowing);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("the_everything_mod:blocks/easywater"),
						new ResourceLocation("the_everything_mod:blocks/easyweatermoving")).luminosity(1).density(100).viscosity(100))
								.bucket(() -> bucket).block(() -> block);
		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("easy_water");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("easy_water_flowing");
		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER)) {
			@Override
			public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
				super.onEntityCollision(state, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					EasyWaterMobplayerCollidesBlockProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("easy_water"));
		elements.items
				.add(() -> new BucketItem(still, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(EverythingmodItemGroup.tab))
						.setRegistryName("easy_water_bucket"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, new LakesFeature(BlockStateFeatureConfig::deserialize) {
				@Override
				public boolean place(IWorld world, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
					DimensionType dimensionType = world.getDimension().getType();
					boolean dimensionCriteria = false;
					if (dimensionType == DimensionType.OVERWORLD)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.place(world, generator, rand, pos, config);
				}
			}.withConfiguration(new BlockStateFeatureConfig(block.getDefaultState()))
					.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(5))));
		}
	}
}
