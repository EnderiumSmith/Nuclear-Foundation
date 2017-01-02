package NuclearFoundation.GUI;

import java.io.IOException;

import NuclearFoundation.NuclearFoundation;
import NuclearFoundation.core.Constants;
import NuclearFoundation.networking.MessageMetalWorker;
import NuclearFoundation.tile_entity.TileMetalworker;
import NuclearFoundation.tile_entity.TileMetalworker.EnumMetalRecipe;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GuiMetalworker extends GuiContainer{

	public TileMetalworker tile;
	public GuiMetalworker(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		tile=((ContainerMetalworker)inventorySlotsIn).Tile;
		this.xSize = 176;
        this.ySize = 166;
	}
	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(new GuiButtonSlot(0, this.guiLeft+134, this.guiTop+8, EnumMetalRecipe.PLATE.getLocation()));
		this.buttonList.add(new GuiButtonSlot(1, this.guiLeft+152, this.guiTop+8, EnumMetalRecipe.GEAR.getLocation()));
		this.buttonList.add(new GuiButtonSlot(2, this.guiLeft+134, this.guiTop+26, EnumMetalRecipe.ROD.getLocation()));
		this.buttonList.add(new GuiButtonSlot(3, this.guiLeft+152, this.guiTop+26, EnumMetalRecipe.NUGGET.getLocation()));
		this.buttonList.add(new GuiButtonInvisible(4, this.guiLeft+80, this.guiTop+26, 16, 16, ""));
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		BlockPos pos=tile.getPos();
		NuclearFoundation.netInstance.sendToServer(new MessageMetalWorker(pos.getX(),pos.getY(),pos.getZ(),button.id));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.MODID+":textures/gui/metalworker.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		float prog=(float)tile.Progress/(float)tile.MaxProgress;
        int dist=Math.min((int)(prog*18), 18);
        this.drawTexturedModalRect(this.guiLeft+61, this.guiTop+43, 176, 0, dist, 16);
		if(tile.currentRecipe!=null){
			mc.getRenderItem().renderItemIntoGUI(tile.currentRecipe.getLocation(), this.guiLeft+80,this.guiTop+26);
		}
	}

}
