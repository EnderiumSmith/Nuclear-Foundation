package NuclearFoundation.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class GuiButtonSlot extends GuiButtonInvisible{

	ItemStack item;
	public GuiButtonSlot(int buttonId, int x, int y,ItemStack in) {
		super(buttonId, x, y, 16, 16, "");
		item=in;
	}
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		mc.getRenderItem().renderItemIntoGUI(item, this.xPosition, this.yPosition);
	}

}
