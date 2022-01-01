package com.nyfaria.dogitems.items;

import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class DogRunItem extends Item {
    public DogRunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.world.isClient) {
            for(int i = 0; i < 5; i++) {
                TntEntity tntEntity = new TntEntity(user.world, user.getPos().getX() + 0.5D, user.getPos().getY(), user.getPos().getZ() + 0.5D, user);
                user.world.spawnEntity(tntEntity);
                user.world.playSound((PlayerEntity) null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
                user.world.emitGameEvent(user, GameEvent.PRIME_FUSE, user.getBlockPos());
            }
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,400, 3));
        return super.use(world, user, hand);
    }
}
