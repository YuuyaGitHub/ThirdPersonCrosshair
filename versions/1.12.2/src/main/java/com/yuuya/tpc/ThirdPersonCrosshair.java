package com.yuuya.tpc;

import com.yuuya.tpc.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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

    @SidedProxy(
        clientSide = "com.yuuya.tpc.proxy.ClientProxy",
        serverSide = "com.yuuya.tpc.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }
}
