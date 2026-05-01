package net.bensome01.vegan_plants.neoforge;

import net.bensome01.vegan_plants.VeganPlants;
import net.bensome01.vegan_plants.config.ModConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(VeganPlants.MOD_ID)
public final class VeganPlantsNeoForge{
    // Run our common setup.
    public VeganPlantsNeoForge(IEventBus bus, ModContainer container) {
        container.registerConfig(net.neoforged.fml.config.ModConfig.Type.SERVER, ModConfig.getServerSpec());

        VeganPlants.init();
    }
}
