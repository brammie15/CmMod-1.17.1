package com.brammie15.brammiecmmod.common.block.cm_centrifuge_new;

import com.brammie15.brammiecmmod.CmMod;
import com.brammie15.brammiecmmod.core.init.BlockEntityInit;
import com.brammie15.brammiecmmod.core.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class NewCmCentrifugeBlockEntity extends BlockEntity{
    public List<String> code = new ArrayList<>();
    public int currentLine;
    public int waitCounter;
    public double speed = 2f;
    public int loopCount;
    public int loopPosition = -1;
    public boolean running;

    public int timer = 0;

    protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
    private final int amountOfSlots = 2;


    public NewCmCentrifugeBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState blockState) {
        super(blockEntityType, pos, blockState);
    }

    public NewCmCentrifugeBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(BlockEntityInit.CM_CENTRIFUGE.get(), blockPos, blockState);
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("codeSize", code.size());
        for (int i = 0; i < code.size(); i++) {
            tag.putString("codeLine" + i, code.get(i));
        }
        tag.putInt("currentLine", currentLine);
        tag.putInt("waitCounter", waitCounter);
        tag.putInt("loopCount", loopCount);
        tag.putInt("loopPosition", loopPosition);
        tag.putDouble("speed", speed);
        tag.putBoolean("running", running);
        return new ClientboundBlockEntityDataPacket(getBlockPos(), -1, tag);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        CompoundTag tag = pkt.getTag();

        int codeSize = tag.getInt("codeSize");
        code = new ArrayList<>();
        for (int i = 0; i < codeSize; i++) {
            code.add(i, tag.getString("codeLine" + i));
        }
        currentLine = tag.getInt("currentLine");
        waitCounter = tag.getInt("waitCounter");
        loopCount = tag.getInt("loopCount");
        loopPosition = tag.getInt("loopPosition");
        running = tag.getBoolean("running");
        speed = tag.getDouble("speed");
    }

    public void tick() {
        //whatever
//        if (getLevel() != null) {
//            getLevel().setBlock(this.getBlockPos().above(), BlockInit.CMIUM_ORE.get().defaultBlockState(), 3);
//        }
//        CmMod.LOGGER.info("tick");
    }



    public static void tick(Level level, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity) {
        if (!level.isClientSide && blockEntity instanceof NewCmCentrifugeBlockEntity cmCentrifugeBlockEntity) {
            cmCentrifugeBlockEntity.tick();
        }
    }
    //Not Tested
    public IItemHandler getInventory() {
        return (IItemHandler) items;
    }
}
