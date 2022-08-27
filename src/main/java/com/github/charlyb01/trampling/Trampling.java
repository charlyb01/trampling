package com.github.charlyb01.trampling;

import com.github.charlyb01.trampling.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.state.property.BooleanProperty;

public class Trampling implements ModInitializer {
    public static final BooleanProperty STUNNED = BooleanProperty.of("stunned");

    @Override
    public void onInitialize() {
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
    }
}
