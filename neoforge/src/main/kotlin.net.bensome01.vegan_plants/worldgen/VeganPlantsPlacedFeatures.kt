package net.Winston.vegan_plants.worldgen

import net.bensome01.vegan_plants.VeganPlants
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.minecraft.world.level.levelgen.placement.RarityFilter

object VeganPlantsPlacedFeatures {
    val WILD_FEATHER_PLACED_KEY: net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature?> =
        registerKey("wild_feather_placed_key")

    fun bootstrap(context: BootstrapContext<net.minecraft.world.level.levelgen.placement.PlacedFeature?>) {
        val configuredFeatures: net.minecraft.core.HolderGetter<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<*, *>?> =
            context.lookup(net.minecraft.core.registries.Registries.CONFIGURED_FEATURE)

        context.register(
            VeganPlantsPlacedFeatures.WILD_FEATHER_PLACED_KEY,
            net.minecraft.world.level.levelgen.placement.PlacedFeature(
                configuredFeatures
                    .getOrThrow(VeganPlantsConfiguredFeatures.WILD_FEATHER_KEY),
                listOf<PlacementModifier?>(
                    RarityFilter.onAverageOnceEvery(100),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome()
                )
            )
        )
    }

    //RarityFilter.onAverageOnceEvery(300), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
    private fun registerKey(name: kotlin.String?): net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature?> {
        return net.minecraft.resources.ResourceKey.create<net.minecraft.world.level.levelgen.placement.PlacedFeature?>(
            net.minecraft.core.registries.Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(VeganPlants.MOD_ID, name)
        )
    }

    private fun register(
        context: BootstrapContext<net.minecraft.world.level.levelgen.placement.PlacedFeature?>,
        key: net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature?>?,
        configuration: net.minecraft.core.Holder<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<*, *>?>?,
        modifiers: kotlin.collections.MutableList<net.minecraft.world.level.levelgen.placement.PlacementModifier?>
    ) {
        context.register(
            key,
            net.minecraft.world.level.levelgen.placement.PlacedFeature(
                configuration,
                java.util.List.copyOf<net.minecraft.world.level.levelgen.placement.PlacementModifier?>(modifiers)
            )
        )
    }
} // //register a placed feature
// context.register
// (
//     //create a resource key for it to be known as
//     ResourceKey.create
//     (
//         Registries.PLACED_FEATURE,
//         new ResourceLocation
//         (
//             TutorialMod.MOD_ID,
//             "pine_placed"
//         )
//     ),
//     //define the placed feature
//     new PlacedFeature
//     (
//         //Holder<ConfiguredFeature<?, ?>> feature
//         context.lookup
//         (
//             Registries.CONFIGURED_FEATURE
//         ).getOrThrow
//         (
//             ModConfiguredFeatures.PINE_KEY
//         ),
//         //List<PlacementModifier> placement
//         List.copyOf
//         (
//             VegetationPlacements.treePlacement
//             (
//                 PlacementUtils.countExtra
//                 (
//                     3,
//                     0.1f,
//                     2
//                 ),
//                 ModBlocks.PINE_SAPLING.get()
//             )
//         )
//     )
// );

