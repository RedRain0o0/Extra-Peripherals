package io.github.redrain0o0.cccams;

import dan200.computercraft.api.peripheral.PeripheralLookup;
import io.github.redrain0o0.cccams.blocks.CccamsBlocks;
import io.github.redrain0o0.cccams.blocks.entity.CccamsBlockEntities;
import io.github.redrain0o0.cccams.peripherals.CameraPeripheral;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cccams implements ModInitializer {
    public static final String MOD_ID = "cccams";
    public static final Logger LOGGER = LoggerFactory.getLogger("CC Cameras");
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing common...");
        CccamsBlocks.initialize();
        CccamsBlockEntities.initialize();
        PeripheralLookup.get().registerForBlockEntity((f,s) -> new CameraPeripheral(f), CccamsBlockEntities.CAMERA_BLOCK_ENTITY);
    }

    public static ResourceLocation createId(String id) {
        return new ResourceLocation(MOD_ID, id);
    }
}
