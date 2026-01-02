package com.yuuya.tpc.proxy;

import com.yuuya.tpc.CrosshairHandler;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        MinecraftForge.EVENT_BUS.register(new CrosshairHandler());
    }
}
