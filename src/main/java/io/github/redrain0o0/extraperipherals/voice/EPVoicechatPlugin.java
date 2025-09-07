package io.github.redrain0o0.extraperipherals.voice;

import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.VoicechatServerStartedEvent;
import io.github.redrain0o0.extraperipherals.ExtraPeripherals;

public class EPVoicechatPlugin implements VoicechatPlugin {
    @Override
    public String getPluginId() {
        return ExtraPeripherals.MOD_ID;
    }

    @Override
    public void initialize(VoicechatApi api) {
        ExtraPeripherals.LOGGER.info("Extra Peripherals Voice Chat plugin initialized");
    }

    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(VoicechatServerStartedEvent.class, this::onServerStarted, 100);
    }

    public void onServerStarted(VoicechatServerStartedEvent event) {
        ExtraPeripherals.LOGGER.info("{}", event.getVoicechat());
    }
}
