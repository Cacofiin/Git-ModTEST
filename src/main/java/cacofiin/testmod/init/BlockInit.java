package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;

import cacofiin.testmod.objects.blocks.SpecialBlock;
import cacofiin.testmod.objects.blocks.TileBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Objects;

public class BlockInit{
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static final RegistryObject<Block> example_block = BLOCKS.register("example_block", () -> new Block(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    public static final RegistryObject<Block> example_ore = BLOCKS.register("example_ore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3.4f,20.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> example_advblock = BLOCKS.register("example_advblock", () -> new SpecialBlock(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,10.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0)));

    public static final RegistryObject<Block> example_tile = BLOCKS.register("example_tile", () -> new TileBlock(Block.Properties.create(Material.WOOD)
            .hardnessAndResistance(0.7f,5.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)));
}
