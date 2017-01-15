package NuclearFoundation.GUI;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.IFluidTank;

public class GuiHelper {
	
	public static void drawFluidTankUp(int X,int Y,int sizeY,IFluidTank tank, GuiContainer gui){
		drawFluidTankUp(X, Y, 16, sizeY, tank, gui);
	}
	public static void drawFluidTankUp(int X,int Y,int sizeX,int sizeY,IFluidTank tank, GuiContainer gui){
		if(tank.getFluid()!=null){
			if(tank.getFluid().getFluid().isGaseous()){
				//render gas tank
				TextureAtlasSprite fluidSprite=gui.mc.getTextureMapBlocks().getTextureExtry(tank.getFluid().getFluid().getStill().toString());
				gui.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
				float filled=(float)tank.getFluidAmount()/(float)tank.getCapacity();
				GlStateManager.enableBlend();
				GlStateManager.color(1F, 1F, 1F, filled);
				gui.drawTexturedModalRect(X, Y, fluidSprite, sizeX, sizeY);
				GlStateManager.disableBlend();
				
			}else{
				//render liquid tank
				TextureAtlasSprite fluidSprite=gui.mc.getTextureMapBlocks().getTextureExtry(tank.getFluid().getFluid().getStill().toString());
				gui.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
				float filled=(float)tank.getFluidAmount()/(float)tank.getCapacity();
				int y=(int)(sizeY*(1-filled));
				GlStateManager.enableBlend();
				gui.drawTexturedModalRect(X, Y+y, fluidSprite, sizeX, sizeY-y);
				GlStateManager.disableBlend();
			}
		}
	}
	public static void drawProgressBarUp(int X,int Y,int locX,int locY,int sizeX,int sizeY,float progress, GuiContainer gui,ResourceLocation texture){
		gui.mc.getTextureManager().bindTexture(texture);
		int y=(int)(sizeY*(1-progress));
		gui.drawTexturedModalRect(X, Y+y, locX, locY+y, sizeX, sizeY-y);
	}

}
