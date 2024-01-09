package com.hector.minermod.item;

//Class that creates and registers all the modded items for the minermod mod

import com.hector.minermod.MinerMod;


import com.hector.minermod.entity.ModEntityTypes;
import com.hector.minermod.entity.custom.ChomperEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    /** Creates a deferred register
     *   - Creates a registry to hold the registered item object for the mod that are created later
     *  - .create method takes the existing ITEMS register in Forge, and a mod id/name
     *      - stores the new items in Forge under the name of the mod id
     *          - items can be accessed now using "mod_id:item_name"
     */
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MinerMod.MODID);

    /** Creates an item object that will be registered to ITEMS
     *  - Takes a name
     *  - Takes a Supplier (can be a custom class with its own properties)
     *  - add .tab(tabName) at the end of the supplier to add the item to a tab in creative mode
     */

    //ORE
    // Supplier for ores just need an Item supplier
    public static final RegistryObject<Item> ACMIUM = ITEMS.register("acmium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)));
    public static final RegistryObject<Item> RAW_ACMIUM = ITEMS.register("raw_acmium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)));


    //tools
    // Supplier for tools differ depending on the type and the tier they are
    public static final RegistryObject<Item> ACMIUM_SWORD = ITEMS.register("acmium_sword",
            () -> new SwordItem(Tiers.DIAMOND, 7, 4f,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ACMIUM_PICKAXE = ITEMS.register("acmium_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, 4, 5f,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ACMIUM_AXE = ITEMS.register("acmium_axe",
            () -> new AxeItem(Tiers.DIAMOND, 8, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ACMIUM_HOE = ITEMS.register("acmium_hoe",
            () -> new HoeItem(Tiers.DIAMOND, 3, 5f,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> ACMIUM_HAMMER = ITEMS.register("acmium_hammer",
            () -> new PickaxeItem(Tiers.NETHERITE, 4, 5,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).stacksTo(1)));


    //armor
    // Supplier for armor differ depending on the material, and equipment slot they are
    public static final RegistryObject<Item> ACMIUM_HELMET = ITEMS.register("acmium_helmet",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD,new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)));
    public static final RegistryObject<Item> ACMIUM_CHESTPLATE= ITEMS.register("acmium_chestplate",
            () -> new ArmorItem(ArmorMaterials.DIAMOND,EquipmentSlot.CHEST,new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)));
    public static final RegistryObject<Item> ACMIUM_LEGGINGS = ITEMS.register("acmium_leggings",
            () -> new ArmorItem(ArmorMaterials.DIAMOND,EquipmentSlot.LEGS,new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)));
    public static final RegistryObject<Item> ACMIUM_BOOTS = ITEMS.register("acmium_boots",
            () -> new ArmorItem(ArmorMaterials.DIAMOND,EquipmentSlot.FEET,new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)));

    //food
    // Supplier for food need an Item supplier and add the property .food() to register it as food
    //.food takes a food with its properties
    public static final RegistryObject<Item> BAGEL = ITEMS.register("bagel",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).food(Foods.BAGEL)));
    public static final RegistryObject<Item> PINK_DONUT = ITEMS.register("pink_donut",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).food(Foods.PINK_DONUT)));


    //entity below
    // Supplier for an entity takes a ForgeSpawnEggItem (minecraft generated spawn_egg) which needs
    // the entity, primary hex color, and secondary hex color
    // can add .stacks to change the stacking limit
    public static final RegistryObject<Item> CHOMPER_SPAWN_EGG = ITEMS.register("chomper_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CHOMPER, 0x7d403c, 0x6bcf74,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).stacksTo(16)));


    //Class that initializes the modded Food, and gives it its properties
    // Can be in a separate folder
    public static class Foods{
        //new FoodProperties.Builder() .(add the properties).build();
        public static final FoodProperties BAGEL = new FoodProperties.Builder()
                .nutrition(6).alwaysEat().saturationMod(.6f).build();
        public static final FoodProperties PINK_DONUT = new FoodProperties.Builder()
                .nutrition(7).alwaysEat().saturationMod(.6f).build();
    }

    //registers the ITEMS register we created into the game
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
