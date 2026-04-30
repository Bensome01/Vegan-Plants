package net.bensome01.vegan_plants.registry

import dev.architectury.registry.registries.DeferredRegister
import net.bensome01.vegan_plants.VeganPlants
import net.bensome01.vegan_plants.item.FeatherSeeds
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemNameBlockItem

object ModItemRegistry {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(
        VeganPlants.MOD_ID,
        Registries.ITEM
    )

    val FEATHER_SEEDS = ITEMS.register("feather_seeds") {
        ItemNameBlockItem(ModBlockRegistry.FEATHER_CROP.get(), Item.Properties().`arch$tab`(creativeTab))
    }

//    val WILD_FEATHER = ITEMS.register("wild_feather",) {
//        BlockItem(ModBlockRegistry.WILD_FEATHER.get(), Item.Properties().`arch$tab`(creativeTab))
//    }


    val creativeTab: ResourceKey<CreativeModeTab> = CreativeModeTabs.REDSTONE_BLOCKS

    @JvmStatic
    fun register() {
        ITEMS.register()
    }
}
