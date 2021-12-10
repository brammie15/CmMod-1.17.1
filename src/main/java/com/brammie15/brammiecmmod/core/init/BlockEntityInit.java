package com.brammie15.brammiecmmod.core.init;

import com.brammie15.brammiecmmod.CmMod;
import com.brammie15.brammiecmmod.common.block.entity.CmCentrifugeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CmMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CmCentrifugeBlockEntity>> CM_CENTRIFUGE = BLOCK_ENTITIES.register("cm_centrifuge", () -> BlockEntityType.Builder.of(CmCentrifugeBlockEntity::new, BlockInit.CM_CENTRIFUGE.get()).build(null));
}
