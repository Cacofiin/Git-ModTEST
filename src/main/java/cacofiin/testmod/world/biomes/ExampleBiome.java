package cacofiin.testmod.world.biomes;

import cacofiin.testmod.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.layer.AddSnowLayer;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import org.lwjgl.system.CallbackI;

public class ExampleBiome extends Biome {
    public ExampleBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/taiga/town_centers", 6)));
        this.addStructure(Feature.PILLAGER_OUTPOST.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 8, 2, 8));
        DefaultBiomeFeatures.addBerryBushes(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addGiantSpruceTaigaTrees(this);
        DefaultBiomeFeatures.addGiantTreeTaigaTrees(this);
        DefaultBiomeFeatures.addExtraEmeraldOre(this);
        DefaultBiomeFeatures.addSedimentDisks(this);
        DefaultBiomeFeatures.addTaigaRocks(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);
        DefaultBiomeFeatures.addBlueIce(this);
        DefaultBiomeFeatures.addTaigaLargeFerns(this);
        DefaultBiomeFeatures.addCarvers(this);
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig
                (OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.example_ore.get().getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure
                (new CountRangeConfig(1, 0, 0, 23))));
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig
                (Blocks.SNOW_BLOCK.getDefaultState(), 0)).withPlacement(Placement.FOREST_ROCK.configure
                (new FrequencyConfig(3))));
    }


}
