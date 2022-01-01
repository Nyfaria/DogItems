package com.nyfaria.dogitems.items;

import com.nyfaria.dogitems.DogItems;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DogJumpItem extends Item {
    public DogJumpItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient){
            user.addVelocity(0,1.2,0);
        }
        user.addStatusEffect(new StatusEffectInstance(DogItems.POTION_DELAY, 80));
        return super.use(world, user, hand);
    }
}
