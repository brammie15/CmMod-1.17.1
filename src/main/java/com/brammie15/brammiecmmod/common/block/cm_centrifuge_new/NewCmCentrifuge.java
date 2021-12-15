package com.brammie15.brammiecmmod.common.block.cm_centrifuge_new;

import com.brammie15.brammiecmmod.common.block.BaseHorizontalBlock;
import com.brammie15.brammiecmmod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NewCmCentrifuge extends BaseHorizontalBlock implements EntityBlock {
    public static final VoxelShape SHAPE = Shapes.or(
            Block.box(2.5, 12, 6.5, 5.5, 13, 9.5),
            Block.box(2.5, 5, 6.5, 5.5, 6, 9.5),
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(7, 1, 7, 9, 16, 9),
            Block.box(3, 4, 7, 5, 14, 9),
            Block.box(7, 4, 10.999999999999993, 9, 14, 12.999999999999993),
            Block.box(11, 4, 6.999999999999993, 13, 14, 8.999999999999993),
            Block.box(7, 4, 2.999999999999993, 9, 14, 4.999999999999993),
            Block.box(3, 14, 7, 13, 15, 9),
            Block.box(7, 14, 3, 9, 15, 13),
            Block.box(6.5, 12, 2.5, 9.5, 13, 5.5),
            Block.box(6.5, 5, 2.5, 9.5, 6, 5.5),
            Block.box(10.5, 12, 6.5, 13.5, 13, 9.5),
            Block.box(10.5, 5, 6.5, 13.5, 6, 9.5),
            Block.box(6.5, 12, 10.5, 9.5, 13, 13.5),
            Block.box(6.5, 5, 10.5, 9.5, 6, 13.5)
            );

    public NewCmCentrifuge(Properties properties) {
        super(properties);
        runCalculation(SHAPE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPES.get(state.getValue(HORIZONTAL_FACING));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new NewCmCentrifugeBlockEntity(blockPos, blockState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == BlockEntityInit.CM_CENTRIFUGE.get() ? NewCmCentrifugeBlockEntity::tick : null;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!level.isClientSide){
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if(blockEntity instanceof NewCmCentrifugeBlockEntity){
                //NewCmCentrifugeBlockEntity cmCentrifugeBlockEntity = (NewCmCentrifugeBlockEntity) blockEntity;
                //Objects.requireNonNull(blockEntity.getLevel()).setBlock(blockEntity.getBlockPos().above(3), Blocks.COARSE_DIRT.defaultBlockState(), 3);


                MenuProvider menuProvider = new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return new TextComponent("");
                    }

                    @Nullable
                    @Override
                    public AbstractContainerMenu createMenu(int windowId, Inventory inventory, Player player) {
                        return new NewCmCentrifugeContainerMenu(windowId, inventory);
                    }
                };
                NetworkHooks.openGui((ServerPlayer) player, menuProvider, blockPos);
                return InteractionResult.SUCCESS;
           }
        }

        return super.use(blockState, level, blockPos, player, hand, hitResult);
    }

}
