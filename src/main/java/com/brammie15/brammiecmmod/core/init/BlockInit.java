package com.brammie15.brammiecmmod.core.init;

import com.brammie15.brammiecmmod.CmMod;
import com.brammie15.brammiecmmod.common.block.CmCentrifuge;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CmMod.MOD_ID);

    public static final RegistryObject<Block> CM_BLOCK = BLOCKS.register("cm_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)));

    public static final RegistryObject<CmCentrifuge> CM_CENTRIFUGE = BLOCKS.register("cm_centrifuge", () -> new CmCentrifuge(BlockBehaviour.Properties.copy(Blocks.BREWING_STAND)));
    public static final RegistryObject<Block> CMIUM_ORE = BLOCKS.register("cmium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
}
