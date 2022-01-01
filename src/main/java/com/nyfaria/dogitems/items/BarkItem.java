package com.nyfaria.dogitems.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class BarkItem extends Item {
    public BarkItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        List<Entity> entities = world.getOtherEntities(user, user.getBoundingBox().expand(5.0D, 5.0D, 5.0D).offset(0.0D, 1.0D, 0.0D), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR);
        double d = (user.getBoundingBox().minX + user.getBoundingBox().maxX) / 2.0D;
        double e = (user.getBoundingBox().minZ + user.getBoundingBox().maxZ) / 2.0D;
        Iterator var6 = entities.iterator();
        world.playSound(user,user.getBlockPos(), SoundEvents.ENTITY_WOLF_AMBIENT, SoundCategory.PLAYERS, 10,10);
        while(var6.hasNext()) {
            Entity entity = (Entity)var6.next();
            if (entity instanceof LivingEntity) {
                double f = entity.getX() - d;
                double g = entity.getZ() - e;
                double h = Math.max(f * f + g * g, 0.1D);
                entity.addVelocity(f / h * 4.0D, 0.20000000298023224D, g / h * 4.0D);
            }
        }

        return super.use(world, user, hand);
    }

}
