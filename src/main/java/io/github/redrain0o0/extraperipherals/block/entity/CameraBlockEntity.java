package io.github.redrain0o0.extraperipherals.block.entity;

import io.github.redrain0o0.extraperipherals.peripheral.CameraPeripheral;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipBlockStateContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
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
    private static int[] mapColors;


    public CameraBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ExtraPeripheralsBlockEntities.CAMERA_BLOCK_ENTITY, blockPos, blockState);
        enabled = false;
        pitch = 0;
        yaw = 0;
        goalPitch = 0;
        goalYaw = 0;
        tick = 0;
    }

    public @NotNull CameraPeripheral getPeripheral(@Nullable Direction direction) {
        if (cameraPeripheral == null) cameraPeripheral = new CameraPeripheral(this);
        return cameraPeripheral;
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putBoolean("enabled", enabled);
        compoundTag.putFloat("pitch", pitch);
        compoundTag.putFloat("yaw", yaw);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        enabled = compoundTag.getBoolean("enabled");
        pitch = compoundTag.getFloat("pitch");
        yaw = compoundTag.getFloat("yaw");
    }

    public boolean getEnabled() {
        return enabled;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    @Override
    public void setChanged() {
        level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(),this.getBlockState(), 3);
        super.setChanged();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if (level.isClientSide) return;
        if (!enabled) return;

        ++tick;
        if (tick >= 10) {
            Vec3 center = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            Vec3 direction = new Vec3(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ()).normalize();
            ClipBlockStateContext ctx = new ClipBlockStateContext(center, direction.normalize().multiply(10,10,10), block -> false);

            var test = BlockGetter.traverseBlocks(ctx.getFrom(), ctx.getTo(), ctx.isTargetBlock(), (_ctx, pos) -> {return _ctx;}, (_ctx) -> {return 0;});
            //test.
                    // Logic goes here!
            //mapColors[1] = BlockGetter.traverseBlocks(ctx.getFrom(), ctx.getTo(), ctx.isTargetBlock(), (_ctx, pos) -> {1});
            tick = 0;
        }

        if (pitch - goalPitch < -1 && pitch - goalPitch > 1) pitch = goalPitch;
        if (yaw - goalYaw > -1 && yaw - goalYaw < 1) yaw = goalYaw;

        if (pitch > goalPitch) --pitch;
        else if (pitch < goalPitch) ++pitch;

        if (yaw > goalYaw) --yaw;
        else if (yaw < goalYaw) ++yaw;

        ((ServerLevel) level).addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockState), true, blockPos.getX() + 1.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, 0, 0, 0);
    }
}
