package com.github.charlyb01.trampling.mixin.crops;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TorchflowerBlock;
import net.minecraft.state.StateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.github.charlyb01.trampling.Trampling.STUNNED;

@Mixin(TorchflowerBlock.class)
public class TorchflowerBlockMixin {
    @Inject(method = "appendProperties", at = @At("HEAD"))
    void addStunnedProperty(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(STUNNED);
    }
}
