package com.brammie15.brammiecmmod.common.block.entity;

import com.brammie15.brammiecmmod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CmCentrifugeBlockEntity extends BlockEntity {

    public int height = 2;

    public CmCentrifugeBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.CM_CENTRIFUGE.get(),pos, state);
    }

    public void tick(){
        if(!level.isClientSide){
            if(height > 254){
                height  = 0;

            }
            level.setBlock(this.worldPosition.above(height), Blocks.DIAMOND_BLOCK.defaultBlockState(), 3);
            height++;
        }
    }
}
