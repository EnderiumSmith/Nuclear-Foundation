package NuclearFoundation.GUI;

import NuclearFoundation.core.Constants;
import NuclearFoundation.tile_entity.magma_crucible.TileCrucibleController;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiCrucible extends GuiContainer{

	public TileCrucibleController tile;
	public GuiCrucible(Container container) {
		super(container);
		this.xSize = 176;
        this.ySize = 166;
        this.tile=((ContainerCrucible)container).tile;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		ResourceLocation gui;
		if(tile.energyType==0){
			gui=new ResourceLocation(Constants.MODID+":textures/gui/crucible2.png");
		}else{
			gui=new ResourceLocation(Constants.MODID+":textures/gui/crucible1.png");
		}
		mc.getTextureManager().bindTexture(gui);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		if(tile.recipe!=null&&tile.progress!=-1){
			GuiHelper.drawProgressBarUp(this.guiLeft+80, this.guiTop+45, 176, 0, 14, 14, ((float)(tile.recipe.energy-tile.progress)/(float)tile.recipe.energy), this, gui);
		}
		if(tile.energyType==0){
			for(int f=0;f<2;f++)
				if(tile.burnTime[f+2]!=0)
					GuiHelper.drawProgressBarUp(this.guiLeft+62+((f)*36), this.guiTop+27, 176, 0, 14, 14, (float)tile.burnTime[f]/(float)tile.burnTime[f+2], this, gui);
		}else if(tile.progress>0){
			this.drawTexturedModalRect(this.guiLeft+61, this.guiTop+25, 176, 14, 18, 18);
			this.drawTexturedModalRect(this.guiLeft+98, this.guiTop+25, 176, 14, 18, 18);
		}
		GuiHelper.drawFluidTankUp(this.guiLeft+152, this.guiTop+8, 70, tile.output, this);
	}

}
