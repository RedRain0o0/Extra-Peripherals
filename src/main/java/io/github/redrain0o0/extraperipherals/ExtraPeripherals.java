package io.github.redrain0o0.extraperipherals;

import dan200.computercraft.api.peripheral.PeripheralLookup;
import io.github.redrain0o0.extraperipherals.block.ExtraPeripheralsBlocks;
import io.github.redrain0o0.extraperipherals.block.entity.ExtraPeripheralsBlockEntities;
import io.github.redrain0o0.extraperipherals.peripheral.CameraPeripheral;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* TODO:
 * Camera Raycast
 * Camera Depth Buffer
 * Camera Color Buffer
 * Advanced Camera (the whole thing lmao)
 * Microphone
 * "Stream" option for Rednet/Modems
 * Redstone Cable
 * Peripheral Cable
 * EVA Monitor / EVA Suit (?)
 */

public class ExtraPeripherals implements ModInitializer {
    public static final String MOD_ID = "extraperipherals";
    public static final Logger LOGGER = LoggerFactory.getLogger("Extra Peripherals");

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing common...");
        ExtraPeripheralsBlocks.initialize();
        ExtraPeripheralsBlockEntities.initialize();
        PeripheralLookup.get().registerForBlockEntity((f,s) -> new CameraPeripheral(f), ExtraPeripheralsBlockEntities.CAMERA_BLOCK_ENTITY);
    }

    public static ResourceLocation createId(String id) {
        return new ResourceLocation(MOD_ID, id);
    }
}
