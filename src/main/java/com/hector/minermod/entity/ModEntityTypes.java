package com.hector.minermod.entity;

//Class that creates and registers all the modded entities for the minermod mod

import com.hector.minermod.MinerMod;

import com.hector.minermod.entity.custom.ChomperEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    //Creates a deferred register to hold the modded entities
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MinerMod.MODID);

    //Create variable CHOMPER, registers the entity, taking the name "chomper",
    // its supplier (properties), which takes a name, and a builder with an ModEntity and category its in
    public static final RegistryObject<EntityType<ChomperEntity>> CHOMPER =
            ENTITY_TYPES.register("chomper",
                    () -> EntityType.Builder.of(ChomperEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(MinerMod.MODID, "chomper").toString()));


    //registers the ENTITY_TYPES register we created into the game
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
