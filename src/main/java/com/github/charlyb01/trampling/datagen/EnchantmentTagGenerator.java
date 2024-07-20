package com.github.charlyb01.trampling.datagen;

import com.github.charlyb01.trampling.Trampling;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class EnchantmentTagGenerator extends FabricTagProvider.EnchantmentTagProvider {
    public static final TagKey<Enchantment> PREVENTS_TRAMPLING = TagKey.of(RegistryKeys.ENCHANTMENT,
            Trampling.of("prevents_trampling"));

    public EnchantmentTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(PREVENTS_TRAMPLING)
                .add(Enchantments.FEATHER_FALLING);
    }
}
