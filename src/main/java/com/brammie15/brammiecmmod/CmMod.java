package com.brammie15.brammiecmmod;

import com.brammie15.brammiecmmod.core.init.BlockEntityInit;
import com.brammie15.brammiecmmod.core.init.BlockInit;
import com.brammie15.brammiecmmod.core.init.ItemInit;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CmMod.MOD_ID)
public class CmMod {
    public static final String MOD_ID = "brammiecmmod";

    public CmMod() {
        final var bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        BlockEntityInit.BLOCK_ENTITIES.register(bus);
    }
}
