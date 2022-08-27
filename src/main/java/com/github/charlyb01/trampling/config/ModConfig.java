package com.github.charlyb01.trampling.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "trampling")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    public CropBuff cropBuff = new CropBuff();

    public static class CropBuff {
        public boolean leatherBoots = true;
        public boolean featherFalling = true;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public CropDebuff cropDebuff = new CropDebuff();

    public static class CropDebuff {
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int stunnedOnTrampleChance = 80;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int unstunSuccessChance = 10;
    }


    public static ModConfig get() {
        return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }
}
