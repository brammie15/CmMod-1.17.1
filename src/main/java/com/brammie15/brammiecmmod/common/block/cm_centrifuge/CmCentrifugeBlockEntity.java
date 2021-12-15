//package com.brammie15.brammiecmmod.common.block.cm_centrifuge;
//
//import com.brammie15.brammiecmmod.core.init.BlockEntityInit;
//import com.brammie15.brammiecmmod.core.init.BlockInit;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//
//public class CmCentrifugeBlockEntity extends BlockEntity {
//
//    public int height = 2;
//
//    public CmCentrifugeBlockEntity(BlockPos pos, BlockState state) {
//        super(BlockEntityInit.CM_CENTRIFUGE.get(),pos, state);
//    }
//
//    public void tick(){
//        if(!level.isClientSide){
//            if(height > 254){
//                height  = 2;
//
//            }
//            if(level.getBlockState(this.worldPosition.above(height)).getBlock() == Blocks.AIR){
//                level.setBlock(this.worldPosition.above(height), BlockInit.CM_BLOCK.get().defaultBlockState(), 3);
//            }
//            height++;
//        }
//    }
//}
