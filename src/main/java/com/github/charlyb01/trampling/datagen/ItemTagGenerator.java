package com.github.charlyb01.trampling.datagen;

import com.github.charlyb01.trampling.Trampling;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> NO_TRAMPLING_FOOT_WEARABLES = TagKey.of(RegistryKeys.ITEM,
            Trampling.of("no_trampling_foot_wearables"));

    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(NO_TRAMPLING_FOOT_WEARABLES)
                .add(Items.LEATHER_BOOTS);
    }
}
