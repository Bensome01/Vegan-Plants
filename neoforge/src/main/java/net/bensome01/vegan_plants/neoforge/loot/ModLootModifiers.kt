package net.bensome01.vegan_plants.neoforge.loot

import com.mojang.serialization.MapCodec
import net.bensome01.vegan_plants.VeganPlants
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.common.loot.IGlobalLootModifier
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries
import java.util.function.Supplier


object ModLootModifiers {
    val LOOT_MODIFIER_SERIALIZERS: DeferredRegister<MapCodec<out IGlobalLootModifier>> =
        DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, VeganPlants.MOD_ID)

    val ADD_ITEM: Supplier<MapCodec<out IGlobalLootModifier>> =
        LOOT_MODIFIER_SERIALIZERS.register("add_item", Supplier { AddItemModifier.CODEC })

    @JvmStatic
    fun register(eventBus: IEventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus)
    }
}