package NuclearFoundation.GUI;

import NuclearFoundation.core.Constants;
import NuclearFoundation.tile_entity.TileStirlingGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiStirling extends GuiContainer{

	public TileStirlingGenerator tile;
	public GuiStirling(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		tile=((ContainerStirling)inventorySlotsIn).Tile;
		this.xSize = 176;
        this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.MODID+":textures/gui/stirling.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		if(tile.lastFuelValue!=0)
			GuiHelper.drawProgressBarUp(this.guiLeft+71, this.guiTop+27, 176, 0, 14, 14, (float)tile.burnTime/(float)tile.lastFuelValue, this, new ResourceLocation(Constants.MODID+":textures/gui/stirling.png"));
	}

}
