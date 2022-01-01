package com.nyfaria.dogitems;

import com.nyfaria.dogitems.items.BarkItem;
import com.nyfaria.dogitems.items.BuffDogItem;
import com.nyfaria.dogitems.items.DogJumpItem;
import com.nyfaria.dogitems.items.DogRunItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

public class DogItems implements ModInitializer {

	public static final Item BARK_ITEM = new BarkItem(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item DOG_RUN_ITEM = new DogRunItem(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item DOG_JUMP_ITEM = new DogJumpItem(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item BUFF_DOG_ITEM = new BuffDogItem(new FabricItemSettings().group(ItemGroup.MISC));
	public static final FallStatusEffect POTION_DELAY = new FallStatusEffect();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		Registry.register(Registry.ITEM,new Identifier("dogitems","bark"), BARK_ITEM);
		Registry.register(Registry.ITEM,new Identifier("dogitems","dogrun"), DOG_RUN_ITEM);
		Registry.register(Registry.ITEM,new Identifier("dogitems","dogjump"), DOG_JUMP_ITEM);
		Registry.register(Registry.ITEM,new Identifier("dogitems","buffdog"), BUFF_DOG_ITEM);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("dogitems", "falleffect"), POTION_DELAY);


	}
}
