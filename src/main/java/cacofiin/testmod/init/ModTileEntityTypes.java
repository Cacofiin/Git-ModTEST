package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;
import cacofiin.testmod.tileentity.ExampleTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes{
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, TestMod.MOD_ID);

    public static final RegistryObject<TileEntityType<ExampleTile>> EXAMPLE_TILE = TILE_ENTITY_TYPES.register("example_tile", () -> TileEntityType.Builder.create(ExampleTile::new, BlockInit.example_tile.get()).build(null));
}
