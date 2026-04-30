package net.bensome01.vegan_plants.neoforge.datagen

import net.bensome01.vegan_plants.VeganPlants
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.data.event.GatherDataEvent
import java.util.List
import java.util.function.Function

@EventBusSubscriber(modid = VeganPlants.MOD_ID)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val packOutput = generator.packOutput
        val existingFileHelper = event.existingFileHelper
        val lookupProvider = event.lookupProvider

//        generator.addProvider(
//            event.includeServer(), LootTableProvider(
//                packOutput, mutableSetOf<ResourceKey<LootTable?>?>(),
//                List.of<LootTableProvider.SubProviderEntry?>(
//                    LootTableProvider.SubProviderEntry(
//                        Function { ModBlockLootTableProvider() },
//                        LootContextParamSets.BLOCK
//                    )
//                ), lookupProvider
//            )
//        )
//        generator.addProvider(event.includeServer(), ModRecipeProvider(packOutput, lookupProvider))

//        val blockTagsProvider: BlockTagsProvider = ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper)
//        generator.addProvider(event.includeServer(), blockTagsProvider)
//        generator.addProvider(
//            event.includeServer(),
//            ModItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper)
//        )

//        generator.addProvider(event.includeServer(), ModDataMapProvider(packOutput, lookupProvider))
//
//        generator.addProvider(event.includeClient(), ModItemModelProvider(packOutput, existingFileHelper))
        generator.addProvider(event.includeClient(), ModBlockStateProvider(packOutput, existingFileHelper))
//
//        generator.addProvider(event.includeServer(), ModDatapackProvider(packOutput, lookupProvider))
//        generator.addProvider(event.includeServer(), ModGlobalLootModifierProvider(packOutput, lookupProvider))
    }
}