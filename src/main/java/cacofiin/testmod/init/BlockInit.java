package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;

import cacofiin.testmod.objects.blocks.ModStoneButton;
import cacofiin.testmod.objects.blocks.ModStonePressurePlate;
import cacofiin.testmod.objects.blocks.SpecialBlock;
import cacofiin.testmod.objects.blocks.TileBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
import org.lwjgl.system.CallbackI;

import java.util.Objects;

public class BlockInit{
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static final RegistryObject<Block> example_block = BLOCKS.register("example_block", () -> new Block(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    public static final RegistryObject<Block> example_ore = BLOCKS.register("example_ore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3.4f,20.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> example_advblock = BLOCKS.register("example_advblock", () -> new SpecialBlock(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,10.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0)));

    public static final RegistryObject<Block> example_tile = BLOCKS.register("example_tile", () -> new TileBlock(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(0.7f,5.0f).sound(SoundType.ANVIL).harvestTool(ToolType.AXE).harvestLevel(0)));

    public static final RegistryObject<Block> example_stairs = BLOCKS.register("example_stairs", () -> new StairsBlock(() -> example_block.get().getDefaultState(), Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    public static final RegistryObject<Block> example_fence = BLOCKS.register("example_fence", () -> new FenceBlock(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    public static final RegistryObject<Block> example_button = BLOCKS.register("example_button", () -> new ModStoneButton(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    public static final RegistryObject<Block> example_pressure_plate = BLOCKS.register("example_pressure_plate", () -> new ModStonePressurePlate(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    public static final RegistryObject<Block> example_slab = BLOCKS.register("example_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    public static final RegistryObject<Block> example_wall = BLOCKS.register("example_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(0.7f,15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
}
