package com.brammie15.brammiecmmod;

import com.brammie15.brammiecmmod.common.block.cm_centrifuge_new.NewCmCentrifugeContainerMenu;
import com.brammie15.brammiecmmod.common.block.cm_centrifuge_new.NewCmCentrifugeScreen;
import com.brammie15.brammiecmmod.core.init.*;
import com.google.common.eventbus.Subscribe;
import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.logging.Logger;

@Mod(CmMod.MOD_ID)
public class CmMod {
    public static final String MOD_ID = "brammiecmmod";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);
    public CmMod() {
        final var bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        BlockEntityInit.BLOCK_ENTITIES.register(bus);
        EffectInit.EFFECTS.register(bus);
        MenuInit.MENUS.register(bus);
    }
    //make a fucntion that takes in a vector and return the normaziled vector

    public static void setup(FMLClientSetupEvent e) {
        MenuScreens.register(MenuInit.CM_CENTRIFUGE_MENU.get(), NewCmCentrifugeScreen::new);
    }
}
