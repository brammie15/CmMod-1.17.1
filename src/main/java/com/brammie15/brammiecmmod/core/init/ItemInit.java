package com.brammie15.brammiecmmod.core.init;

import com.brammie15.brammiecmmod.CmMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    //make a deferredRegister for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CmMod.MODID);

    //make a item named raw_cum and register it to the ITEMS DeferredRegister
    public static final RegistryObject<Item> RAW_CM = ITEMS.register("raw_cm", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<Item> REFINED_CM = ITEMS.register("refined_cm", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<Item> CM_INGOT = ITEMS.register("cm_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    //Blocks
    public static final RegistryObject<BlockItem> CM_BLOCK = ITEMS.register("cm_block", () -> new BlockItem(BlockInit.CM_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));


}
