package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Objects;

@ObjectHolder(TestMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Bus.MOD)
public class BlockInit{

    public static final Block example_block = null;

    @SubscribeEvent
    public static void registerBlock(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("example_block"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new BlockItem(example_block, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_block"));
    }
}
