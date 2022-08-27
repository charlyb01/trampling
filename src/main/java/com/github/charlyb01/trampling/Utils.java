package com.github.charlyb01.trampling;

import com.github.charlyb01.trampling.config.ModConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.github.charlyb01.trampling.Trampling.STUNNED;

public class Utils {
    public static void tryStunAround(final World world, final BlockPos pos) {
        if (!world.isClient() && world.getTime() % 5 == 0
                && world.getRandom().nextInt(100) < ModConfig.get().cropDebuff.stunnedOnTrampleChance) {
            for (BlockPos randomPos : BlockPos.iterateRandomly(world.getRandom(), 3, pos, 1)) {
                BlockState randomPosState = world.getBlockState(randomPos);
                if (randomPosState.contains(STUNNED)) {
                    world.setBlockState(randomPos, randomPosState.with(STUNNED, true));
                }
            }
        }
    }
}
