package io.github.redrain0o0.cccams.blocks.entity;

import io.github.redrain0o0.cccams.peripherals.CameraPeripheral;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CameraBlockEntity extends BlockEntity {
    private CameraPeripheral cameraPeripheral;
    public static boolean enabled;
    public static float pitch;
    public static float yaw;
    public static float goalPitch;
    public static float goalYaw;
    private static int tick;

    public CameraBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(CccamsBlockEntities.CAMERA_BLOCK_ENTITY, blockPos, blockState);
        enabled = false;
        pitch = 0;
        yaw = 0;
        goalPitch = 0;
        goalYaw = 0;
        tick = 0;
    }

    public @NotNull CameraPeripheral getPeriipheral(@Nullable Direction direction) {
        if (cameraPeripheral == null) cameraPeripheral = new CameraPeripheral(this);
        return cameraPeripheral;
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putBoolean("camera.enabled", enabled);
        compoundTag.putFloat("camera.pitch", pitch);
        compoundTag.putFloat("camera.yaw", yaw);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        enabled = compoundTag.getBoolean("camera.enabled");
        pitch = compoundTag.getFloat("camera.pitch");
        yaw = compoundTag.getFloat("camera.yaw");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if (level.isClientSide) return;
        if (!enabled) return;

        ++tick;
        if (tick >= 10) {
            // Logic goes here!
            tick = 0;
        }

        if (pitch - goalPitch < -1 && pitch - goalPitch > 1) pitch = goalPitch;
        if (yaw - goalYaw > -1 && yaw - goalYaw < 1) yaw = goalYaw;

        if (pitch > goalPitch) --pitch;
        else if (pitch < goalPitch) ++pitch;

        if (yaw > goalYaw) --yaw;
        else if (yaw < goalYaw) ++yaw;
    }
}
