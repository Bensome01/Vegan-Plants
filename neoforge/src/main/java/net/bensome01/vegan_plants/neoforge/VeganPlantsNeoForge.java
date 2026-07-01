package net.bensome01.vegan_plants.neoforge;

import net.bensome01.vegan_plants.VeganPlants;
import net.bensome01.vegan_plants.config.ModConfig;
import net.bensome01.vegan_plants.neoforge.loot.ModLootModifiers;
import net.bensome01.vegan_plants.registry.ComposterRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(VeganPlants.MOD_ID)
public final class VeganPlantsNeoForge{
    // Run our common setup.
    public VeganPlantsNeoForge(IEventBus bus, ModContainer container) {
        container.registerConfig(net.neoforged.fml.config.ModConfig.Type.SERVER, ModConfig.getServerSpec());
        ModLootModifiers.register(bus);

        VeganPlants.init();

        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
//        event.enqueueWork(ComposterRegistry::register);
    }
}
