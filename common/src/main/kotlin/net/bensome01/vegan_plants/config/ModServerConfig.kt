package net.bensome01.vegan_plants.config

import net.neoforged.neoforge.common.ModConfigSpec

class ModServerConfig (builder: ModConfigSpec.Builder) {
    val MINIMUM_FEATHER_CROP_y: ModConfigSpec.IntValue
    val FEATHER_FALL_DURATION: ModConfigSpec.IntValue
    val MINIMUM_WILD_FEATHER_y: ModConfigSpec.IntValue
    val GENERATE_FEATHER_SEEDS_CHEST_LOOT: ModConfigSpec.BooleanValue
            init {
        builder.comment("Configs of for Vegan Plants")
        builder.push("Feather Crop")
            MINIMUM_FEATHER_CROP_y = builder
                .comment("Minimum_Y that feather crop can grow\"")
                .defineInRange("minimum_Y", 100, -64, 320)
            FEATHER_FALL_DURATION = builder
                .comment("Tick duration of feather fall effect gratned by matured feather crop")
                .defineInRange("tick_duration", 200, 0, Int.MAX_VALUE)
        builder.pop()
        builder.push("Wild Feather")
                MINIMUM_WILD_FEATHER_y = builder
                    .comment("Minimum y that Wild feather can be placed (this effects world gen)")
                    .defineInRange("minimum_y", 100, -64, 320)
        builder.pop()
        builder.push("Chest Loot")
                GENERATE_FEATHER_SEEDS_CHEST_LOOT = builder
                    .comment("Whether feather seeds can generate in chest loot")
                    .define("generate", true)
    }
}
