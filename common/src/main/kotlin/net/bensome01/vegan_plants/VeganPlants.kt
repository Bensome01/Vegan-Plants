package net.bensome01.vegan_plants

import net.bensome01.vegan_plants.registry.ComposterRegistry
import net.bensome01.vegan_plants.registry.ModBlockRegistry
import net.bensome01.vegan_plants.registry.ModItemRegistry
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

// The value here should match an entry in the META-INF/mods.toml file
object VeganPlants {
    const val MOD_ID: String = "vegan_plants"

    val LOGGER: Logger = LogManager.getLogger("Vegan Plants")

    @JvmStatic
    fun init() {
        ModBlockRegistry.register()
        ModItemRegistry.register()
//        ComposterRegistry.register()
    }
}

        //load configs
//        ModLoadingContext.get()
//            .registerConfig(ModConfig.Type.COMMON, VeganPlantsConfig.GENERAL_SPEC, "vegan_plants.toml")
        //loot modifers
//        ModLootModifiers.register(modEventBus)

    //Register composter
//    private fun commonSetup(event: FMLCommonSetupEvent) {
//        event.enqueueWork({
//            ComposterRegistry.registerCompost()
//        })
//    }

    // Add the example block item to the building blocks tab
//    private fun addCreative(event: BuildCreativeModeTabContentsEvent) {
//        if (event.getTabKey() === CreativeModeTabs.NATURAL_BLOCKS) {
//            event.accept(ItemRegistry.FEATHER_SEEDS)
//            event.accept(ItemRegistry.WILD_FEATHER)
//        }
//    }
