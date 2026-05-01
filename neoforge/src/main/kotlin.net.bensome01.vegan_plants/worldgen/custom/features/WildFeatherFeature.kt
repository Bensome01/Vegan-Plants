package net.Winston.vegan_plants.worldgen.custom.features

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
import net.minecraft.world.level.levelgen.feature.VegetationPatchFeature
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration

class WildFeatherFeature : VegetationPatchFeature(VegetationPatchConfiguration.CODEC) {
    //For future world Gen Config
    override fun place(p_160612_: FeaturePlaceContext<VegetationPatchConfiguration>): Boolean {
        return super.place(p_160612_)
    }
}
