package cacofiin.testmod.util;

import cacofiin.testmod.TestMod;
import cacofiin.testmod.init.DimensionsInit;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus= Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event){
        if(DimensionType.byName(TestMod.EXAMPLE_DIM_TYPE) == null){
            DimensionManager.registerDimension(TestMod.EXAMPLE_DIM_TYPE, DimensionsInit.example_dimension.get(), null, true);
        }
        TestMod.LOGGER.info("Dimensions Registered !");
    }
}
