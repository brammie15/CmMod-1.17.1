package com.brammie15.brammiecmmod.common.block;

import com.brammie15.brammiecmmod.CmMod;
import com.brammie15.brammiecmmod.core.init.BlockInit;
import com.brammie15.brammiecmmod.core.init.ItemInit;
import com.ibm.icu.impl.CalendarAstronomer;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class CmCentrifuge extends HorizontalDirectionalBlock {
    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<Direction, VoxelShape>(Direction.class);
    public CmCentrifuge(Properties props) {
        super(props);
        registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
        runCalculation(SHAPE.orElse(Shapes.block()));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);

    }
    protected void runCalculation(VoxelShape shape) {
        for (Direction direction : Direction.values())
            SHAPES.put(direction, CmMod.calculateShapes(direction, shape));
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    private static final Optional<VoxelShape> SHAPE = Stream.of(
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

    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!level.isClientSide){
            player.addItem(new ItemStack(ItemInit.REFINED_CM.get(),2)); //this is 100% sure jank code
            level.getServer().getPlayerList().broadcastMessage(new TranslatableComponent("chat.cm.centrifuge.use"), ChatType.SYSTEM, Util.NIL_UUID);

        }
        return InteractionResult.SUCCESS;
    }
}
