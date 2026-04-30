package net.bensome01.vegan_plants.block

import net.minecraft.core.BlockPos
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.monster.Ravager
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.GameRules
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.IntegerProperty
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape
import net.bensome01.vegan_plants.config.ModConfig
import net.bensome01.vegan_plants.registry.ModItemRegistry
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.RandomSource
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.state.properties.BlockStateProperties

class FeatherCropBlock(pProperties: Properties) : CropBlock(pProperties) {
    private val SHAPE_BY_AGE = arrayOf<VoxelShape>(
        box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0)
    )

    //changed protection level
    protected override fun getShape(
        blockState: BlockState,
        blockGetter: BlockGetter,
        blockPos: BlockPos,
        collisionContext: CollisionContext
    ): VoxelShape {
        return SHAPE_BY_AGE[this.getAge(blockState)]
    }

    override fun getBaseSeedId(): ItemLike {
        return ModItemRegistry.FEATHER_SEEDS.get()
    }

    public override fun getAgeProperty(): IntegerProperty {
        return AGE
    }

    override fun getMaxAge(): Int {
        return MAX_AGE
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block?, BlockState?>) {
        pBuilder.add(AGE)
    }

    //changed protection level
    protected override fun entityInside(blockstate: BlockState, level: Level, blockPos: BlockPos, entity: Entity) {
        if (entity is Ravager && level.gameRules.getBoolean(GameRules.RULE_MOBGRIEFING)) {
            level.destroyBlock(blockPos, true, entity)
        }

        if (this.getAge(blockstate) == MAX_AGE && !level.isClientSide) {
            if (entity is LivingEntity) {
                entity.addEffect(
                    MobEffectInstance(
                        MobEffects.SLOW_FALLING,
                        ModConfig.SERVER.FEATHER_FALL_DURATION.get()
                    )
                )
                entity.resetFallDistance()
            }
        }
    }

//    SLOW_FALLING = register("slow_falling", new Potion(new MobEffectInstance[]{new MobEffectInstance(MobEffects.SLOW_FALLING, 1800)}));

    override fun isValidBonemealTarget(
        levelReader: LevelReader,
        blockPos: BlockPos,
        blockState: BlockState
    ): Boolean {
        return blockPos.y >= ModConfig.SERVER.MINIMUM_FEATHER_CROP_y.get()
                && super.isValidBonemealTarget(levelReader, blockPos, blockState)
    }
    // LevelReader p_255715_, BlockPos p_52259_, BlockState p_52260_, boolean p_52261_

    public override fun randomTick(
        blockState: BlockState,
        serverLevel: ServerLevel,
        blockPos: BlockPos,
        randomSource: RandomSource
    ) {
        if (blockPos.y < ModConfig.SERVER.MINIMUM_FEATHER_CROP_y.get()) {
            return
        }
        super.randomTick(blockState, serverLevel, blockPos, randomSource)
    }

    companion object {
        val MAX_AGE: Int = 15
        val AGE: IntegerProperty = BlockStateProperties.AGE_15
    }
}
