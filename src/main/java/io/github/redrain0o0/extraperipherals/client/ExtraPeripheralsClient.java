package io.github.redrain0o0.extraperipherals.client;

import io.github.redrain0o0.extraperipherals.block.entity.ExtraPeripheralsBlockEntities;
import io.github.redrain0o0.extraperipherals.block.entity.renderer.CameraBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class ExtraPeripheralsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(ExtraPeripheralsBlockEntities.CAMERA_BLOCK_ENTITY, CameraBlockEntityRenderer::new);
    }
}
