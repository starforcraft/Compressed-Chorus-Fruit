package com.YTrollman.CompressedChorusFruit.items;

import com.YTrollman.CompressedChorusFruit.config.CompressedChorusFruitConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class CompressedChorusFruitItem extends Item {
    public CompressedChorusFruitItem(Item.Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, World world, LivingEntity livingEntity) {
        ItemStack itemstack = super.finishUsingItem(itemStack, world, livingEntity);
        if (!world.isClientSide) {
            Random rand = new Random();

            double x = rand.nextInt(CompressedChorusFruitConfig.COMPRESSED_CHORUS_FRUIT_MAX_X_RANGE.get()) + 0.5D;
            double y = rand.nextInt(CompressedChorusFruitConfig.COMPRESSED_CHORUS_FRUIT_MAX_Y_RANGE.get()) + 0.5D;
            double z = rand.nextInt(CompressedChorusFruitConfig.COMPRESSED_CHORUS_FRUIT_MAX_Z_RANGE.get()) + 0.5D;

            if (livingEntity.isPassenger()) {
                livingEntity.stopRiding();
            }

            livingEntity.teleportTo(x, y, z);

            PlaceGlassBox(world, x, y, z);

            SoundEvent soundevent = livingEntity instanceof FoxEntity ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
            world.playSound(null, x, y, z, soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
            livingEntity.playSound(soundevent, 1.0F, 1.0F);

            if (livingEntity instanceof PlayerEntity) {
                ((PlayerEntity)livingEntity).getCooldowns().addCooldown(this, 36000);
            }
        }

        return itemstack;
    }

    private void PlaceGlassBox(World world, double x, double y, double z)
    {
        //Ground
        world.setBlock(new BlockPos(x, y - 1, z), Blocks.GLASS.defaultBlockState(), 0);

        //Ground + 1
        world.setBlock(new BlockPos(x, y, z - 1), Blocks.GLASS.defaultBlockState(), 0);

        world.setBlock(new BlockPos(x - 1, y, z), Blocks.GLASS.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y, z), Blocks.GLASS.defaultBlockState(), 0);

        world.setBlock(new BlockPos(x, y, z + 1), Blocks.GLASS.defaultBlockState(), 0);

        //Top - 1
        world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.GLASS.defaultBlockState(), 0);

        world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.GLASS.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.GLASS.defaultBlockState(), 0);

        world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.GLASS.defaultBlockState(), 0);

        //Top
        world.setBlock(new BlockPos(x, y + 2, z), Blocks.GLASS.defaultBlockState(), 0);
    }
}
