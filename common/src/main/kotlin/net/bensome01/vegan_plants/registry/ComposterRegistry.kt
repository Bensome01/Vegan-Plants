package net.bensome01.vegan_plants.registry

import net.minecraft.world.item.Item
import net.minecraft.world.level.block.ComposterBlock

object ComposterRegistry {
    @JvmStatic
    fun register() {
        registerCompost(ModItemRegistry.FEATHER_SEEDS.get(), 0.3f)
        registerCompost(ModBlockRegistry.WILD_FEATHER.get().asItem(), 0.3f)
    }

    private fun registerCompost(item: Item, chance: Float) {
        ComposterBlock.COMPOSTABLES.put(item, chance)
    }
}