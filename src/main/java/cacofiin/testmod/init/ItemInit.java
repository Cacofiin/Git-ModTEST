package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;

import cacofiin.testmod.objects.items.SeptemberMusicDiscItem;
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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import org.lwjgl.system.CallbackI;

import javax.swing.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ItemInit{
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    //item (ore)
    public static final RegistryObject<Item> example_item = ITEMS.register("example_item", () -> new Item(new Item.Properties().group(TestMod.TestItemGroup.instance)));

    //food
    public static final RegistryObject<Item> example_food = ITEMS.register("example_food", () -> new Item(new Item.Properties().group(TestMod.TestItemGroup.instance)
            .food(new Food.Builder().hunger(1).saturation(0.5f).setAlwaysEdible().effect(new EffectInstance(Effects.GLOWING, 60, 1),1).build())));

    //advanced item
    public static final RegistryObject<Item> example_advitem = ITEMS.register("example_advitem", () -> new SpecialItem(new Item.Properties().group(TestMod.TestItemGroup.instance).maxStackSize(1)));

    //armour
    public static final RegistryObject<Item> example_helmet = ITEMS.register("example_helmet",() -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(TestMod.TestItemGroup.instance)));
    public static final RegistryObject<Item> example_chestplate = ITEMS.register("example_chestplate",() -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(TestMod.TestItemGroup.instance)));
    public static final RegistryObject<Item> example_leggings = ITEMS.register("example_leggings",() -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(TestMod.TestItemGroup.instance)));
    public static final RegistryObject<Item> example_boots = ITEMS.register("example_boots",() -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(TestMod.TestItemGroup.instance)));

    //tools
    public static final RegistryObject<Item> example_sword = ITEMS.register("example_sword", () -> new SwordItem(ModItemTier.EXAMPLE, 6, 2.3f, new Item.Properties().group(TestMod.TestItemGroup.instance)));
    public static final RegistryObject<Item> example_pickaxe = ITEMS.register("example_pickaxe", () -> new PickaxeItem(ModItemTier.EXAMPLE, 4, 2.5f, new Item.Properties().group(TestMod.TestItemGroup.instance)));
    public static final RegistryObject<Item> example_axe = ITEMS.register("example_axe", () -> new AxeItem(ModItemTier.EXAMPLE, 7, 1.9f, new Item.Properties().group(TestMod.TestItemGroup.instance)));
    public static final RegistryObject<Item> example_shovel = ITEMS.register("example_shovel", () -> new ShovelItem(ModItemTier.EXAMPLE, 5, 2.5f, new Item.Properties().group(TestMod.TestItemGroup.instance)));
    public static final RegistryObject<Item> example_hoe = ITEMS.register("example_hoe", () -> new HoeItem(ModItemTier.EXAMPLE,2.5f, new Item.Properties().group(TestMod.TestItemGroup.instance)));

    //discs
    public static final RegistryObject<Item> sept_disc = ITEMS.register("music_disc_september",
            () -> new SeptemberMusicDiscItem(5, SoundInit.LAZY_SEPTEMBER_MUSIC.get(),
            new Item.Properties().group(TestMod.TestItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));

    //mod item tier ABOVE diamond
    public enum ModItemTier implements IItemTier{
        EXAMPLE(4, 1748, 12.0f, 6.0f, 12, () -> {
           return Ingredient.fromItems(example_item.get());
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
        TEST(TestMod.MOD_ID+ ":example", 12, new int[] {4,7,9,4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f, () -> {
           return Ingredient.fromItems(ItemInit.example_item.get());
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