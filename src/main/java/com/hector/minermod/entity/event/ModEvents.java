package com.hector.minermod.entity.event;

//Class that give the entity's events and sets its attributes

import com.hector.minermod.MinerMod;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import com.hector.minermod.entity.ModEntityTypes;
import com.hector.minermod.entity.custom.ChomperEntity;
import com.hector.minermod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import java.util.List;
public class ModEvents {
    @Mod.EventBusSubscriber(modid = MinerMod.MODID)
    public static class ForgeEvents {

        @Mod.EventBusSubscriber(modid = MinerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ModEventBusEvents {
            //places the entity into an event and sets its attributes
            @SubscribeEvent
            public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
                event.put(ModEntityTypes.CHOMPER.get(), ChomperEntity.setAttributes());
            }
        }
    }
}
