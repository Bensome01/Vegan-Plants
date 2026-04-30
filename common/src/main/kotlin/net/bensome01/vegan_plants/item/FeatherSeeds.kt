package net.bensome01.vegan_plants.item

import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemNameBlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.block.Block

class FeatherSeeds(block: Block?, pProperties: Properties) : ItemNameBlockItem(block, pProperties) {
    override fun appendHoverText(
        arg: ItemStack,
        arg2: TooltipContext,
        list: MutableList<Component>,
        arg3: TooltipFlag
    ) {
        list.add(Component.translatable("tooltip.vegan_plants.feather_seeds.tooltip"))
        super.appendHoverText(arg, arg2, list, arg3)
    }
}
// ItemStack arg, TooltipContext arg2, List<Component> list, TooltipFlag arg3