package com.yuuya.tpc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class CrosshairHandler extends Gui {

    private static final Minecraft mc = Minecraft.getMinecraft();
    private static final ResourceLocation ICONS =
            new ResourceLocation("textures/gui/icons.png");

    @SubscribeEvent
    public void onRenderCrosshair(RenderGameOverlayEvent.Pre event) {

        if (event.getType() != RenderGameOverlayEvent.ElementType.CROSSHAIRS) return;
        if (mc.player == null) return;

        // Completely remove the Vanilla crosshair
        event.setCanceled(true);

        ScaledResolution sr = event.getResolution();

        mc.getTextureManager().bindTexture(ICONS);

        GL11.glColor4f(1F, 1F, 1F, 1F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_ONE_MINUS_DST_COLOR, GL11.GL_ONE_MINUS_SRC_COLOR);

        int x = sr.getScaledWidth() / 2 - 7;
        int y = sr.getScaledHeight() / 2 - 7;

        // Same UV as Vanilla (center of 16x16)
        this.drawTexturedModalRect(x, y, 0, 0, 16, 16);

        GL11.glDisable(GL11.GL_BLEND);
    }
}