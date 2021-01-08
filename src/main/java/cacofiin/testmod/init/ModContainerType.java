package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;
import cacofiin.testmod.container.ExampleChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerType {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, TestMod.MOD_ID);

    public static final RegistryObject<ContainerType<ExampleChestContainer>> example_chest = CONTAINER_TYPES.register("example_chest",
            () -> IForgeContainerType.create(ExampleChestContainer::new));
}
