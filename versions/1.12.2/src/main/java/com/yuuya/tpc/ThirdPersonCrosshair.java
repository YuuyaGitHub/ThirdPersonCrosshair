package com.yuuya.tpc;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(
    modid = ThirdPersonCrosshair.MODID,
    name = ThirdPersonCrosshair.NAME,
    version = ThirdPersonCrosshair.VERSION,
    clientSideOnly = true
)
public class ThirdPersonCrosshair {

    public static final String MODID = "tpc";
    public static final String NAME = "ThirdPersonCrosshair";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new CrosshairHandler());
    }
}