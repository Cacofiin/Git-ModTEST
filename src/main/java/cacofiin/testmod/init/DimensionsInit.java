package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;
import cacofiin.testmod.world.dimension.ExampleModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionsInit {
    public static final DeferredRegister<ModDimension> MOD_DIMENSION = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, TestMod.MOD_ID);

    public static final RegistryObject<ModDimension> example_dimension = MOD_DIMENSION.register("example_dimension", () -> new ExampleModDimension());
}
