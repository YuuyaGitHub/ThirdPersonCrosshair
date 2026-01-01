package com.yuuya.tpc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CrosshairHandler extends Gui {

    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        // Crosshair drawing timing only
        if (event.getType() != RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            return;
        }

        // Do not draw when GUI is hidden
        if (mc.gameSettings.hideGUI) {
            return;
        }

        // If not in third person, does nothing (normal crosshair appears)
        if (mc.gameSettings.thirdPersonView == 0) {
            return;
        }

        // Do not draw when in spectator mode
        if (mc.player == null || mc.player.isSpectator()) {
            return;
        }

        int width = event.getResolution().getScaledWidth();
        int height = event.getResolution().getScaledHeight();

        mc.getTextureManager().bindTexture(ICONS);

        drawTexturedModalRect(
                width / 2 - 7,
                height / 2 - 7,
                0, 0,
                16, 16
        );
    }
}
