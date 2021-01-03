package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;

import cacofiin.testmod.objects.blocks.SpecialBlock;
import cacofiin.testmod.objects.blocks.TileBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
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

    //blocks
    public static final Block example_block = null;

    //ore
    public static final Block example_ore = null;

    //advanced blocks
    public static final Block example_advblock=null;

    //tile entities
    public static final Block example_tile=null;

    @SubscribeEvent
    public static void registerBlock(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)).setRegistryName("example_block"));
        event.getRegistry().register(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.4f,20.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("example_ore"));
        event.getRegistry().register(new SpecialBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f,10.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0)).setRegistryName("example_advblock"));
        event.getRegistry().register(new TileBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.7f,5.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName("example_tile"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new BlockItem(example_block, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_block"));
        event.getRegistry().register(new BlockItem(example_ore, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_ore"));
        event.getRegistry().register(new BlockItem(example_advblock, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_advblock"));
        event.getRegistry().register(new BlockItem(example_tile, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_tile"));
    }
}
