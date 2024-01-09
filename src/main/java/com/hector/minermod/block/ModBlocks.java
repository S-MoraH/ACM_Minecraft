package com.hector.minermod.block;

//Class that creates and registers all the modded blocks for the minermod mod
import com.hector.minermod.MinerMod;
import com.hector.minermod.item.ModCreativeModeTab;
import com.hector.minermod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;

public class ModBlocks {

    /** Creates a deferred register
     *   - Creates a registry to hold the registered block object for the mod that are created later
     *  - .create method takes the existing BLOCKS register in Forge, and a mod id/name
     *      - stores the new blocks in Forge under the name of the mod id
     *          - blocks can be accessed now using "mod_id:block_name"
     */
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MinerMod.MODID);

    /** Creates an object to be registered
     *  - Takes the name of a modded block (used to be referenced in other files)
     *  - Takes a supplier (i.e. an anonymous function initializes a class that describes the modded blocks properties)
     *      - Can be a custom class that extend BlockBehaviour or an existing class from minecraft
     *       - custom class would describe the properties that the modded block has
     *       - using an existing class, call the properties that describes the block
     *      - *Add the tab that the modded blocks would be placed in in-game*
    */

    //Create variable ACM_BLOCK, calls the method registerBlock, taking the name "acm_block",
    // its supplier (properties) and the tab ModCreativeModeTab.MOD_TAB to be placed in
    public static final RegistryObject<Block> ACM_BLOCK = registerBlock("acm_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.MOD_TAB);

    //Create variable ACM_ORE, calls the method registerBlock, taking the name "acm_ore",
    // its supplier (properties) and the tab ModCreativeModeTab.MOD_TAB to be placed in
    public static final RegistryObject<Block> ACM_ORE = registerBlock("acm_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.MOD_TAB);

    //Create variable  DEEPSLATE_ACM_ORE, calls the method registerBlock, taking the name "deepslate_acm_ore",
    // its supplier (properties) and the tab ModCreativeModeTab.MOD_TAB to be placed in
    public static final RegistryObject<Block> DEEPSLATE_ACM_ORE = registerBlock("deepslate_acm_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.MOD_TAB);

    //Create variable  ENDSTONE_ZIRCON_ORE, calls the method registerBlock, taking the name "endstone_zircon_ore",
    // its supplier (properties) and the tab ModCreativeModeTab.MOD_TAB to be placed in
    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registerBlock("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(8f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.MOD_TAB);

    //Create variable  NETHERRACK_ZIRCON_ORE, calls the method registerBlock, taking the name "netherrack_zircon_ore",
    // its supplier (properties) and the tab ModCreativeModeTab.MOD_TAB to be placed in
    public static final RegistryObject<Block> NETHERRACK_ZIRCON_ORE = registerBlock("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.5f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.MOD_TAB);


    //Method that registers the new modded blocks into the deferred register for blocks
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        //creates a object to register, toReturn, and registers it to Forge taking in the name and properties of the block
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        //calls the registerBlockItem method, taking the name, the registered block object and the tab it will be stored in
        registerBlockItem(name, toReturn, tab);

        //returns the resgistered object
        return toReturn;
    }

    /** Blocks in minecraft also need to be registered as an item for them to work in game
     *  - blocks in game are generated/placed into the world, and can also be picked up by the player
     *  when broken
     *      - so block can be in two different "states" and are treated as such
     *          - treated as a block when it is in the world or placed by player
     *          - treated as an item the player has on hand or in inventory
     * - needs to be registered as a deferred register for item as well
     */

    //Method that registers the newly registered blocks into the deferred register for items
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        //returns a method call to ModItems to register an item (a block in this case)
        //sends the name, a new BlockItem Supplier that takes its properties and the tab where the block is placed
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    //registers the BLOCKS register we created into the game
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
