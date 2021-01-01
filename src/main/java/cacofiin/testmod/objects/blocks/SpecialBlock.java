package cacofiin.testmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class SpecialBlock extends Block {
    public static final DirectionProperty FACING= HorizontalBlock.HORIZONTAL_FACING;

    public SpecialBlock(Properties properties){
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE_N= Stream.of(Block.makeCuboidShape(5, 0, 3, 11, 2, 13),
            Block.makeCuboidShape(7, 0, 2, 9, 1, 3)).reduce((v1,v2) ->
            VoxelShapes.combineAndSimplify(v1,v2,IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_W= Stream.of(Block.makeCuboidShape(3, 0, 5, 13, 2, 11),
            Block.makeCuboidShape(2, 0, 7, 3, 1, 9)).reduce((v1,v2) ->
            VoxelShapes.combineAndSimplify(v1,v2,IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_S= Stream.of(Block.makeCuboidShape(5, 0, 3, 11, 2, 13),
            Block.makeCuboidShape(7, 0, 13, 9, 1, 14)).reduce((v1,v2) ->
            VoxelShapes.combineAndSimplify(v1,v2,IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_E= Stream.of(Block.makeCuboidShape(3, 0, 5, 13, 2, 11),
            Block.makeCuboidShape(13, 0, 7, 14, 1, 9)).reduce((v1,v2) ->
            VoxelShapes.combineAndSimplify(v1,v2,IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)){
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
