package com.brammie15.brammiecmmod.core.init;

import com.brammie15.brammiecmmod.CmMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ItemInit {
    //make a deferredRegister for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CmMod.MOD_ID);

    //make a item named raw_cum and register it to the ITEMS DeferredRegister
    public static final RegistryObject<Item> RAW_CM = ITEMS.register("raw_cm", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<Item> REFINED_CM = ITEMS.register("refined_cm", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<Item> CM_INGOT = ITEMS.register("cm_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Item> CM_BEEF = ITEMS.register("cm_beef", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(new FoodProperties.Builder().effect(() -> new MobEffectInstance(EffectInit.CM_ENRICHED_EFFECT.get()),100.0f).nutrition(3).saturationMod(0.3F).meat().build())));
    public static final RegistryObject<Item> CM_CHICKEN = ITEMS.register("cm_chicken", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.CHICKEN.getFoodProperties())));
    public static final RegistryObject<Item> CM_PORKCHOP = ITEMS.register("cm_porkchop", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.PORKCHOP.getFoodProperties())));
    public static final RegistryObject<Item> CM_RABBIT = ITEMS.register("cm_rabbit", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.RABBIT.getFoodProperties())));
    public static final RegistryObject<Item> CM_MUTTON = ITEMS.register("cm_mutton", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.MUTTON.getFoodProperties())));
    public static final RegistryObject<Item> CM_COOKED_BEEF = ITEMS.register("cm_cooked_beef", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.COOKED_BEEF.getFoodProperties())));
    public static final RegistryObject<Item> CM_COOKED_CHICKEN = ITEMS.register("cm_cooked_chicken", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.COOKED_CHICKEN.getFoodProperties())));
    public static final RegistryObject<Item> CM_COOKED_PORKCHOP = ITEMS.register("cm_cooked_porkchop", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.COOKED_PORKCHOP.getFoodProperties())));
    public static final RegistryObject<Item> CM_COOKED_RABBIT = ITEMS.register("cm_cooked_rabbit", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.COOKED_RABBIT.getFoodProperties())));
    public static final RegistryObject<Item> CM_COOKED_MUTTON = ITEMS.register("cm_cooked_mutton", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).food(Items.COOKED_MUTTON.getFoodProperties())));


    //Blocks
    public static final RegistryObject<BlockItem> CM_BLOCK = ITEMS.register("cm_block", () -> new BlockItem(BlockInit.CM_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> CM_CENTRIFUGE = ITEMS.register("cm_centrifuge", () -> new BlockItem(BlockInit.CM_CENTRIFUGE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> CMIUM_ORE = ITEMS.register("cmium_ore", () -> new BlockItem(BlockInit.CMIUM_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));


}
