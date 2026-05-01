package net.Winston.vegan_plants.worldgen

import net.bensome01.vegan_plants.VeganPlants
import net.bensome01.vegan_plants.registry.ModBlockRegistry
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.data.worldgen.features.FeatureUtils
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider

//Feature.RandomPatch for grass
object VeganPlantsConfiguredFeatures {
    @JvmField
    val WILD_FEATHER_KEY: ResourceKey<ConfiguredFeature<*, *>?> = registerKey("wild_feather")

    fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>?>) {
        context.register(
            WILD_FEATHER_KEY,
            ConfiguredFeature<FeatureConfiguration, Feature<FeatureConfiguration>>(
                Feature.RANDOM_PATCH as Feature<FeatureConfiguration>,  //there is probably a builder for this but this works
                FeatureUtils.simplePatchConfiguration<SimpleBlockConfiguration?, Feature<SimpleBlockConfiguration?>?>(
                    Feature.SIMPLE_BLOCK,
                    SimpleBlockConfiguration(
                        BlockStateProvider
                            .simple(ModBlockRegistry.WILD_FEATHER.get())
                    ),
                    listOf<Block>(Blocks.GRASS_BLOCK)
                )
            )
        )
    }

    fun registerKey(name: String): ResourceKey<ConfiguredFeature<*, *>?> {
        return ResourceKey.create<ConfiguredFeature<*, *>?>(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(VeganPlants.MOD_ID, name)
        )
    }

    private fun <FC : FeatureConfiguration?, F : Feature<FC?>?> register(
        context: BootstrapContext<ConfiguredFeature<*, *>?>,
        key: ResourceKey<ConfiguredFeature<*, *>?>?, feature: F?, configuration: FC?
    ) {
        context.register(key, ConfiguredFeature<FC?, F?>(feature, configuration))
    }
}
