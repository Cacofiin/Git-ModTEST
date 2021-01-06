package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;
import cacofiin.testmod.world.biomes.ExampleBiome;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.TaigaBiome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, TestMod.MOD_ID);

    public static final RegistryObject<Biome> example_biome = BIOMES.register("example_biome", () -> new ExampleBiome(new Biome.Builder()
            .waterColor(0x8292bd).temperature(0.10f).precipitation(Biome.RainType.SNOW).scale(0.2f).waterFogColor(0x9199ae)
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), BlockInit.example_block.get().getDefaultState(), null))
            .downfall(-0.6f).depth(0.2f).category(Biome.Category.ICY).parent(null)));

    public static void registerBiomes(){
        registerBiome(example_biome.get(), BiomeManager.BiomeType.ICY, 2, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
    }
}
