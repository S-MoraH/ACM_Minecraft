package com.hector.minermod;

import com.hector.minermod.block.ModBlocks;
import com.hector.minermod.entity.client.renderer.ChomperRenderer;
import com.hector.minermod.entity.ModEntityTypes;
import com.hector.minermod.generation.ModConfiguredFeatures;
import com.hector.minermod.generation.ModPlacedFeatures;
import com.hector.minermod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MinerMod.MODID)

public class MinerMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "minermod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();



    //constructor
    public MinerMod()
    {
        //Instantiate  mod event bus
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the modded blocks deferred register to the mod event bus so blocks get registered to the game
        ModBlocks.register(modEventBus);

        // Register the modded items deferred register to the mod event bus so items get registered to the game
        ModItems.register(modEventBus);

        // Register the blocks generation deferred register to the mod event bus so blocks get genereated and registered to the game
        ModConfiguredFeatures.register(modEventBus);

        // Register the blocks generation deferred register to the mod event bus so blocks get placed and registered to the game
        ModPlacedFeatures.register(modEventBus);

        // Register the modded Entities deferred register to the mod event bus so an entity gets registered to the game
        ModEntityTypes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        //Initialize the Gecko libary
        GeckoLib.initialize();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            EntityRenderers.register(ModEntityTypes.CHOMPER.get(), ChomperRenderer::new);

        }
    }
}
