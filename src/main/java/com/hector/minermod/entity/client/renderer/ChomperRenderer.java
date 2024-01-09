package com.hector.minermod.entity.client.renderer;

//Class responsible for rendering the entity into minecraft

import com.hector.minermod.MinerMod;
import com.hector.minermod.entity.client.models.ChomperModel;
import com.hector.minermod.entity.custom.ChomperEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

// Renderers for a modded entity extends GeoEntityRenderer<ModdedEntity> and overrides methods
public class ChomperRenderer extends GeoEntityRenderer<ChomperEntity> {
    // constructor that takes a new render object (::new) and instantiates a new EntityModel
    // calls super class and gives it a shadow
    public ChomperRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ChomperModel());
        this.shadowRadius = 0.3f;
    }

    //Overrides the method to find the (entity_)texture.png file for an entity
    @Override
    public ResourceLocation getTextureLocation(ChomperEntity instance) {
        return new ResourceLocation(MinerMod.MODID, "textures/entity/chomper_texture.png");
    }

    // Overrides the method to render an entity, taking in the necessary components
    @Override
    public RenderType getRenderType(ChomperEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
