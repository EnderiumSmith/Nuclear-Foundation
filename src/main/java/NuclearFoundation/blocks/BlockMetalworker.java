package NuclearFoundation.blocks;

import NuclearFoundation.NuclearFoundation;
import NuclearFoundation.items.CustomCreativeTabs;
import NuclearFoundation.items.ItemCrank;
import NuclearFoundation.tile_entity.TileMetalworker;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMetalworker extends BlockContainer{

	protected BlockMetalworker() {
		super(Material.ANVIL);
		setRegistryName("BlockMetalworker");
		setUnlocalizedName(getRegistryName().toString());
		setHardness(5);
		setResistance(10);
		setHarvestLevel("pickaxe", 0);
		setCreativeTab(CustomCreativeTabs.TabBlocks);
	}
	public void register(){
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this),getRegistryName());
	}
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		super.breakBlock(worldIn, pos, state);
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileMetalworker();
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
			TileMetalworker tile=(TileMetalworker)worldIn.getTileEntity(pos);
			if(tile!=null){
				if(heldItem!=null&&heldItem.getItem() instanceof ItemCrank){
					tile.Crank(playerIn);
				}
				else{
				playerIn.openGui(NuclearFoundation.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
				}
			}
		}
		return true;
	}

}
