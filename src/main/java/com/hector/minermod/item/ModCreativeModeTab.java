package com.hector.minermod.item;

//Class that creates a new tab for the modded items to be placed in during creative

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;


public class ModCreativeModeTab {
    //Create the tab variable that will be referenced and name it
                                                                    //In-game Name
    public static final CreativeModeTab MOD_TAB = new CreativeModeTab("ModTab") {
        //Overrides the icon method and add a custom icon
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ACMIUM.get());
        }
    };
}
