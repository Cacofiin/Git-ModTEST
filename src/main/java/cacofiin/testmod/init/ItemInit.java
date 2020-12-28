package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;

import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import javax.swing.*;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(TestMod.MOD_ID)
public class ItemInit{

    public static final Item example_item=null;
    public static final Item example_food=null;

    public static final Item example_sword=null;
    public static final Item example_pickaxe=null;
    public static final Item example_axe=null;
    public static final Item example_shovel=null;
    public static final Item example_hoe=null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        //Items
        event.getRegistry().register(new Item(new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_item"));
        event.getRegistry().register(new Item(new Item.Properties().group(TestMod.TestItemGroup.instance).food(new Food.Builder().hunger(1).saturation(0.5f).setAlwaysEdible().effect(new EffectInstance(Effects.GLOWING, 60, 1),1).build())).setRegistryName("example_food"));

        //Tools
        event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 6, 2.3f, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_sword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE, 4, 2.3f, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_pickaxe"));
        event.getRegistry().register(new AxeItem(ModItemTier.EXAMPLE, 7, 2.3f, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_axe"));
        event.getRegistry().register(new ShovelItem(ModItemTier.EXAMPLE, 5, 2.3f, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_shovel"));
        event.getRegistry().register(new HoeItem(ModItemTier.EXAMPLE, 2.3f, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_hoe"));
    }

    //mod item tier ABOVE diamond
    public enum ModItemTier implements IItemTier{
        EXAMPLE(4, 1748, 12.0f, 6.0f, 12, () -> {
           return Ingredient.fromItems(example_item);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
            this.harvestLevel=harvestLevel;
            this.maxUses=maxUses;
            this.efficiency=efficiency;
            this.attackDamage=attackDamage;
            this.enchantability=enchantability;
            this.repairMaterial= new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }
}