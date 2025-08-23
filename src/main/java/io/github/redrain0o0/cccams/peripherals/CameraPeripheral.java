package io.github.redrain0o0.cccams.peripherals;

import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import io.github.redrain0o0.cccams.blocks.entity.CameraBlockEntity;
import org.jspecify.annotations.Nullable;

public class CameraPeripheral implements IPeripheral {
    private final CameraBlockEntity camera;

    public CameraPeripheral(CameraBlockEntity camera) {
        this.camera = camera;
    }
    @Override
    public String getType() {
        return "camera";
    }

    @LuaFunction
    public final boolean enabled() {
        return camera.enabled;
    }

    @LuaFunction
    public final float getPitch() {
        return camera.pitch;
    }

    @LuaFunction
    public final float getYaw() {
        return camera.yaw;
    }

    @LuaFunction
    public final void enable() {
        camera.enabled = true;
    }

    @LuaFunction
    public final void disable() {
        camera.enabled = false;
    }

    @LuaFunction
    public final void setPitch(double  pitch) throws LuaException {
        if (pitch < -45.0F || pitch > 45.0F) throw new LuaException("Expected number in range -45 to 45");
        camera.goalPitch = (float) pitch;
    }

    @LuaFunction
    public final void setYaw(double  yaw) throws LuaException {
        if (yaw < -135.0 || yaw > 135.0) throw new LuaException("Expected number in range -135 to 135");
        camera.goalYaw = (float) yaw;
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof CameraPeripheral o && camera == o.camera;
    }
}
