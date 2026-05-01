package net.bensome01.vegan_plants.config

import net.neoforged.neoforge.common.ModConfigSpec
object ModConfig {
    val SERVER_SPEC: ModConfigSpec
    val SERVER: ModServerConfig
    val COMMON_SPEC: ModConfigSpec
    val COMMON: ModCommonConfig

    init {
        val (serverConfig, serverConfigSpec) = ModConfigSpec.Builder().configure(::ModServerConfig)
        SERVER_SPEC = serverConfigSpec
        SERVER = serverConfig

        val (commonConfig, commonConfigSpec) = ModConfigSpec.Builder().configure(::ModCommonConfig)
        COMMON_SPEC = commonConfigSpec
        COMMON = commonConfig
    }

    @JvmStatic
    public fun getServerSpec(): ModConfigSpec {
        return SERVER_SPEC
    }
}