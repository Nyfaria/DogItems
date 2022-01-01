package com.nyfaria.dogitems.items;

import com.nyfaria.dogitems.DogItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class BuffDogItem extends Item {

    public BuffDogItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        CreeperEntity creeperEntity1 = new CreeperEntity(EntityType.CREEPER,world);
        CreeperEntity creeperEntity2 = new CreeperEntity(EntityType.CREEPER,world);
        creeperEntity1.setPosition(user.getPos().add(user.getRotationVec(1).normalize().multiply(5)).add(0,1,0));
        creeperEntity2.setPosition(user.getPos().add(user.getRotationVec(1).normalize().multiply(5)).add(0,1,0));

        world.spawnEntity(creeperEntity1);
        world.spawnEntity(creeperEntity2);

        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(world);
        lightningEntity.setPosition(user.getPos().add(user.getRotationVec(1).normalize().multiply(5)));
        lightningEntity.setCosmetic(false);
        world.spawnEntity(lightningEntity);
        user.heal(200);
        if(world.isClient){
            user.addVelocity(0,1.3,0);
        }
        List<Entity> entities = world.getOtherEntities(user, user.getBoundingBox().expand(15D, 15D, 15D).offset(0.0D, 1.0D, 0.0D), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR);
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
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,400, 3));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3));
        user.addStatusEffect(new StatusEffectInstance(DogItems.POTION_DELAY, 80));
        return super.use(world, user, hand);
    }
}
