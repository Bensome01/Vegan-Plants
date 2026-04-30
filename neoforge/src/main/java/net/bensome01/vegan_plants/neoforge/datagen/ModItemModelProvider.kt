package net.bensome01.vegan_plants.neoforge.datagen

import net.bensome01.vegan_plants.VeganPlants
import net.bensome01.vegan_plants.registry.ModItemRegistry
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class ModItemModelProvider(output: PackOutput, existingFileHelper: ExistingFileHelper): ItemModelProvider(output, VeganPlants.MOD_ID, existingFileHelper) {
    override fun registerModels() {
        basicItem(ModItemRegistry.FEATHER_SEEDS.get())
    }
}