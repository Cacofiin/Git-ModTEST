package cacofiin.testmod.tileentity;

import cacofiin.testmod.init.ModTileEntityTypes;
import cacofiin.testmod.util.helpers.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public class ExampleTile extends TileEntity implements ITickableTileEntity {

    public int x, y, z, tick;
    boolean initialized=false;

    public ExampleTile(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ExampleTile() {
        this(ModTileEntityTypes.EXAMPLE_TILE.get());
    }

    public void tick(){
        if(!initialized) init();
        tick++;
        if(tick==40){
            tick=0;
            if(y>2) execute();
        }
    }

    private void init() {
        initialized=true;
        x=this.pos.getX() - 1;
        y=this.pos.getY() - 1;
        z=this.pos.getZ() - 1;
        tick=0;
    }

    private void execute(){
        int index = 0;
        Block[] blocksRemoved = new Block[9];
        for(int x = 0; x < 3; x++){
            for(int z = 0; z < 3; z++){
                BlockPos posToBreak = new BlockPos(this.x+x, this.y, this.z+z);
                blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
                destroyBlock(posToBreak, true, null);
                index++;
            }
        }
        this.y--;
    }

    private boolean destroyBlock(BlockPos posToBreak, boolean dropBlock, @Nullable Entity entity) {
        BlockState blockstate = world.getBlockState(posToBreak);
        if(blockstate.isAir(world,posToBreak)) return false;
        else{
            IFluidState ifluidstate = world.getFluidState(posToBreak);
            world.playEvent(2001,posToBreak,Block.getStateId(blockstate));
            if(dropBlock){
                TileEntity tileentity=blockstate.hasTileEntity() ? world.getTileEntity(posToBreak) : null;
                Block.spawnDrops(blockstate, world, this.pos.add(0,1.5,0),tileentity,entity, ItemStack.EMPTY);
            }
            return world.setBlockState(posToBreak,ifluidstate.getBlockState(),3);
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("initvalues", NBTHelper.toNBT(this));
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        CompoundNBT initvalues = compound.getCompound("initvalues");
        if(initvalues!=null){
            this.x=initvalues.getInt("x");
            this.y=initvalues.getInt("y");
            this.z=initvalues.getInt("z");
            this.tick=0;
            initialized=true;
            return;
        }
        init();
    }
}
