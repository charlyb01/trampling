package com.github.charlyb01.trampling;

import com.github.charlyb01.trampling.config.ModConfig;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
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

    public static boolean canCancelTrampleOnLanded(final Entity entity) {
        return (ModConfig.get().cropBuff.leatherBoots && ((LivingEntity) entity).getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS))
                || (ModConfig.get().cropBuff.featherFalling && EnchantmentHelper.getEquipmentLevel(Enchantments.FEATHER_FALLING, (LivingEntity) entity) > 0);
    }

    public static boolean cantCancelTrample(final Entity entity, final World world) {
        return !world.isClient()
                && entity instanceof LivingEntity
                && (entity instanceof PlayerEntity || world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING))
                && !canCancelTrampleOnLanded(entity)
                && (!ModConfig.get().cropBuff.sneaking || !entity.isSneaking());
    }
}
