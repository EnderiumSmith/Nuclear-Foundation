package NuclearFoundation.blocks.magma_crucible;

import java.util.List;

import NuclearFoundation.items.CustomCreativeTabs;
import NuclearFoundation.tile_entity.magma_crucible.TileCrucibleController;
import NuclearFoundation.tile_entity.magma_crucible.TileCrucibleIO;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MagmaCrucibleIOBlock extends BlockContainer implements IMagmaCrucibleStructureBlock{
	
	public int type;
	public MagmaCrucibleIOBlock(String name,int type) {
		super(Material.ANVIL);
		this.type=type;
		setRegistryName(name);
		setUnlocalizedName(getRegistryName().toString());
		setHardness(5);
		setResistance(10);
		setHarvestLevel("pickaxe", 0);
		setCreativeTab(CustomCreativeTabs.TabBlocks);
	}
	public void register(){
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
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
		@SuppressWarnings("rawtypes")
		List list=worldIn.loadedTileEntityList;
		for(int i=0;i<list.size();i++){
			if(list.get(i) instanceof TileCrucibleController){
				if(((TileCrucibleController)list.get(i)).isFormed)
					((TileCrucibleController)list.get(i)).checkStructure();
			}
		}
		super.breakBlock(worldIn, pos, state);
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileCrucibleIO(type);
	}
	@Override
	public void setMaster(BlockPos pos, World world, BlockPos master) {
		((IMagmaCrucibleStructureBlock)world.getTileEntity(pos)).setMaster(pos, world, master);
	}
	@Override
	public boolean hasMaster(BlockPos pos, World world) {
		return ((IMagmaCrucibleStructureBlock)world.getTileEntity(pos)).hasMaster(pos, world);
	}
	@Override
	public void clearMaster(BlockPos pos, World world) {
		((IMagmaCrucibleStructureBlock)world.getTileEntity(pos)).clearMaster(pos, world);
	}
	@Override
	public BlockPos getMaster(BlockPos pos, World world) {
		return ((IMagmaCrucibleStructureBlock)world.getTileEntity(pos)).getMaster(pos, world);
	}
	@Override
	public int getType(BlockPos pos, World world) {
		return ((IMagmaCrucibleStructureBlock)world.getTileEntity(pos)).getType(pos, world);
	}
	

}
