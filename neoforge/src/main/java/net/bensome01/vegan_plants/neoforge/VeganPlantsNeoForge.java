package net.bensome01.vegan_plants.neoforge;

import net.bensome01.vegan_plants.VeganPlants;
import net.neoforged.fml.common.Mod;

@Mod(VeganPlants.MOD_ID)
public final class VeganPlantsNeoForge {
    public VeganPlantsNeoForge() {
        // Run our common setup.
        VeganPlants.init();
    }
}
