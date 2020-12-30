package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;

import cacofiin.testmod.objects.items.SpecialItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

    public static final Item example_advitem=null;

    public static final Item example_item=null;
    public static final Item example_food=null;

    public static final Item example_helmet=null;
    public static final Item example_chestplate=null;
    public static final Item example_leggings=null;
    public static final Item example_boots=null;

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

        //Special items (advanced)
        event.getRegistry().register(new SpecialItem(new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_advitem"));

        //Armor
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_helmet"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_chestplate"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_leggings"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(TestMod.TestItemGroup.instance)).setRegistryName("example_boots"));

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

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
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

    //Mod custom armor
    public enum ModArmorMaterial implements IArmorMaterial{
        TEST(TestMod.MOD_ID+ ":example", 12, new int[] {7,9,11,7}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.9f, () -> {
           return Ingredient.fromItems(ItemInit.example_item);
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {16,16,16,16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent SoundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountArrayIn, int enchantabilityIn, SoundEvent SoundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn){
            this.name=nameIn;
            this.maxDamageFactor=maxDamageFactorIn;
            this.damageReductionAmountArray=damageReductionAmountArrayIn;
            this.enchantability=enchantabilityIn;
            this.SoundEvent=SoundEventIn;
            this.toughness=toughnessIn;
            this.repairMaterial=new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()]*this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.SoundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }
}