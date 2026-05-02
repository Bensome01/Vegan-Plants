package net.bensome01.vegan_plants.neoforge.loot

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import it.unimi.dsi.fastutil.objects.ObjectArrayList
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.storage.loot.LootContext
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition
import net.neoforged.neoforge.common.loot.IGlobalLootModifier
import net.neoforged.neoforge.common.loot.LootModifier


class AddItemModifier(conditionsIn: Array<LootItemCondition>, private val item: Item): LootModifier(conditionsIn) {
    companion object {
        val CODEC: MapCodec<AddItemModifier> = RecordCodecBuilder.mapCodec { inst ->
            codecStart(inst).and(
                BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter { e -> e.item })
                .apply(inst, ::AddItemModifier)
        }
    }

    override fun doApply(
        generatedLoot: ObjectArrayList<ItemStack?>,
        lootContext: LootContext
    ): ObjectArrayList<ItemStack?> {
        for (condition in this.conditions) {
            if (!condition.test(lootContext)) {
                return generatedLoot
            }
        }
        generatedLoot.add(ItemStack(this.item))
        return generatedLoot
    }

    override fun codec(): MapCodec<out IGlobalLootModifier?> {
        return CODEC
    }
}
