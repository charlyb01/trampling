package com.github.charlyb01.trampling;

import com.github.charlyb01.trampling.config.ModConfig;
import com.github.charlyb01.trampling.datagen.ItemTagGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import static com.github.charlyb01.trampling.Trampling.STUNNED;

public class Utils {
    public static void tryStunAround(final World world, final BlockPos pos) {
        if (!world.isClient()
                && world.getRandom().nextInt(100) < ModConfig.get().cropDebuff.stunnedOnTrampleChance) {
            for (BlockPos randomPos : BlockPos.iterateRandomly(world.getRandom(), 3, pos, 1)) {
                BlockState randomPosState = world.getBlockState(randomPos);
                if (randomPosState.contains(STUNNED)) {
                    world.setBlockState(randomPos, randomPosState.with(STUNNED, true));
                }
            }
        }
    }

    public static boolean canCancelTrampleOnLanded(final Entity entity) {
        if (!(entity instanceof LivingEntity livingEntity)) return false;

        ItemStack boots = livingEntity.getEquippedStack(EquipmentSlot.FEET);
        boolean leather = ModConfig.get().cropBuff.leatherBoots && boots.isIn(ItemTagGenerator.NO_TRAMPLING_FOOT_WEARABLES);
        boolean featherFalling = ModConfig.get().cropBuff.featherFalling;

        return leather || featherFalling;
    }

    public static boolean cantCancelTrample(final Entity entity, final World world) {
        return !world.isClient()
                && world.getTime() % 5 == 0
                && entity instanceof LivingEntity
                && (entity instanceof PlayerEntity || world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING))
                && !canCancelTrampleOnLanded(entity)
                && (!ModConfig.get().cropBuff.sneaking || !entity.isSneaking());
    }
}
