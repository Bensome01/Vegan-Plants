package net.bensome01.vegan_plants.neoforge.datagen

import net.bensome01.vegan_plants.VeganPlants
import net.bensome01.vegan_plants.registry.ModBlockRegistry
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.client.model.generators.ConfiguredModel
import net.neoforged.neoforge.common.data.ExistingFileHelper


class ModBlockStateProvider(output: PackOutput?, exFileHelper: ExistingFileHelper?)
    : BlockStateProvider(output, VeganPlants.MOD_ID, exFileHelper) {

    override fun registerStatesAndModels() {
        makeCrop(ModBlockRegistry.FEATHER_CROP.get() as CropBlock, "feather_crop_stage", "feather_crop_stage")
        simpleBlock(
            ModBlockRegistry.WILD_FEATHER.get(),
            models()
                .cross(
                    blockTexture(ModBlockRegistry.WILD_FEATHER.get()).path,
                    blockTexture(ModBlockRegistry.WILD_FEATHER.get())
                )
                .renderType("cutout"))
    }

    fun makeCrop(block: CropBlock, modelName: String, textureName: String) {
        getVariantBuilder(block).forAllStates { state: BlockState ->
            states(state, block, modelName, textureName)
        }
    }

    private fun states(
        state: BlockState,
        block: CropBlock,
        modelName: String,
        textureName: String
    ): Array<ConfiguredModel?> {
        val models = arrayOfNulls<ConfiguredModel>(1)
        models[0] = ConfiguredModel(
            models().crop(
                modelName + state.getValue(block.ageProperty),
                ResourceLocation.fromNamespaceAndPath(
                    VeganPlants.MOD_ID,
                    "block/" + textureName + state.getValue(block.ageProperty)
                )
            ).renderType("cutout")

        )

        return models
    }
/*
    models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(GojiBerryBushBlock.AGE),
    ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(GojiBerryBushBlock.AGE))).renderType("cutout"));
*/
}