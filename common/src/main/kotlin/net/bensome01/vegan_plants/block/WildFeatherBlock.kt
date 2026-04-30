package net.bensome01.vegan_plants.block

import net.bensome01.vegan_plants.config.ModConfig
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.RandomSource
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.TallGrassBlock
import net.minecraft.world.level.block.state.BlockState

class WildFeatherBlock(pProperties: Properties) : TallGrassBlock(pProperties) {
    public override fun canSurvive(blockState: BlockState, levelReader: LevelReader, blockPos: BlockPos): Boolean {
        if (blockPos.y < ModConfig.SERVER.MINIMUM_WILD_FEATHER_y.get()) {
            return false
        }
        return super.canSurvive(blockState, levelReader, blockPos)
    }

    override fun performBonemeal(
        p_222578_: ServerLevel,
        p_222579_: RandomSource,
        p_222580_: BlockPos,
        p_222581_: BlockState
    ) {}
}
