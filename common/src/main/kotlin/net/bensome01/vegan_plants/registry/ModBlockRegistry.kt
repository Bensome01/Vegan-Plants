package net.bensome01.vegan_plants.registry

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import net.bensome01.vegan_plants.VeganPlants
import net.bensome01.vegan_plants.block.FeatherCropBlock
import net.bensome01.vegan_plants.block.WildFeatherBlock
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import java.util.function.Supplier

object ModBlockRegistry {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(
        VeganPlants.MOD_ID,
        Registries.BLOCK
    )

    val FEATHER_CROP: RegistrySupplier<Block> = BLOCKS.register("feather_crop") {
        FeatherCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)
            .noOcclusion().noCollission())
    }

    val WILD_FEATHER: RegistrySupplier<Block> = registerBlockWithItem("wild_feather") {
        WildFeatherBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)
            .noCollission().noOcclusion())
    }

    private fun <T : Block> registerBlockWithItem(name: String?, block: Supplier<T>?): RegistrySupplier<T> {
        val toReturn = BLOCKS.register(name, block)
        val item = ModItemRegistry.ITEMS.register(
            name
        ) { BlockItem(toReturn.get(), Item.Properties().`arch$tab`(ModItemRegistry.creativeTab)) }
        return toReturn
    }

    @JvmStatic
    fun register() {
        BLOCKS.register()
    }
}