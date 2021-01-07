package cacofiin.testmod.world.dimension;

import cacofiin.testmod.init.BiomeInit;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class ExampleBiomeProvider extends BiomeProvider {

    private Random rand;

    protected ExampleBiomeProvider() {
        super(biomeList);
        rand = new Random();
    }

    private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.example_biome.get(), Biomes.SNOWY_TUNDRA, Biomes.SNOWY_TAIGA,
            Biomes.SNOWY_TAIGA_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.FROZEN_RIVER, Biomes.ICE_SPIKES, Biomes.GIANT_TREE_TAIGA);

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return BiomeInit.example_biome.get();
    }
}
