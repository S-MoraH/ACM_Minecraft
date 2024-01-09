package com.hector.minermod.entity.client.models;

// Class that locates the files necessary for a modded entity and
// makes it available for the rest of the files

import com.hector.minermod.entity.custom.ChomperEntity;
import com.hector.minermod.MinerMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;


// Models for a modded entity extends AnimatedGeoModel<ModdedEntity> and overrides methods
public class ChomperModel extends AnimatedGeoModel<ChomperEntity> {

    //Overrides the method to find the geo.json file for an entity
    @Override
    public ResourceLocation getModelResource(ChomperEntity object) {
        return new ResourceLocation(MinerMod.MODID, "geo/chomper.geo.json");
    }

    //Overrides the method to find the (entity_)texture.png file for an entity
    @Override
    public ResourceLocation getTextureResource(ChomperEntity object) {
        return new ResourceLocation(MinerMod.MODID, "textures/entity/chomper_texture.png");
    }

    //Overrides the method to find the animation.json file for an entity
    @Override
    public ResourceLocation getAnimationResource(ChomperEntity animatable) {
        return new ResourceLocation(MinerMod.MODID, "animations/chomper.animation.json");
    }
}
