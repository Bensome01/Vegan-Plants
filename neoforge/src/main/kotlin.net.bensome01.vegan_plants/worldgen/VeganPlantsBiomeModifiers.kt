package net.Winston.vegan_plants.worldgen

import net.bensome01.vegan_plants.VeganPlants
import net.minecraft.core.HolderSet
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BiomeTags
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.registries.NeoForgeRegistries


object VeganPlantsBiomeModifiers {
    val ADD_WILD_FEATHER: net.minecraft.resources.ResourceKey<BiomeModifier?> =
        VeganPlantsBiomeModifiers.registerKey("add_wild_feather")

    //public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

    fun bootstrap(context: BootstrapContext<BiomeModifier>) {
        val biomes = context.lookup(net.minecraft.core.registries.Registries.BIOME)
        val placedFeatures = context.lookup(net.minecraft.core.registries.Registries.PLACED_FEATURE)

        context.register(
            VeganPlantsBiomeModifiers.ADD_WILD_FEATHER,
            BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(VeganPlantsPlacedFeatures.WILD_FEATHER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
            )
        )
    }

    private fun registerKey(name: kotlin.String?): net.minecraft.resources.ResourceKey<BiomeModifier?> {
        return net.minecraft.resources.ResourceKey.create<BiomeModifier?>(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(VeganPlants.MOD_ID, name)
        )
    }
}
