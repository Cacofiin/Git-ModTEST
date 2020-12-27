package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(TestMod.MOD_ID)
public class ItemInit{

    public static final Item example_item=null;
    public static final Item example_food=null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new Item(new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_item"));
        event.getRegistry().register(new Item(new Item.Properties().group(TestMod.TestItemGroup.instance).food(new Food.Builder().hunger(1).saturation(0.5f).setAlwaysEdible().effect(new EffectInstance(Effects.GLOWING, 60, 1),1).build())).setRegistryName("example_food"));
    }
}