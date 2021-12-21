package com.github.charlyb01.trampling.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "trampling")
public class ModConfig implements ConfigData {
    public boolean leatherBoots = true;
    public boolean featherFalling = true;

    public static ModConfig get() {
        return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }
}
