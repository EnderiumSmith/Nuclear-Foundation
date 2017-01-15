package NuclearFoundation.blocks.magma_crucible;

import java.util.List;

import NuclearFoundation.items.CustomCreativeTabs;
import NuclearFoundation.tile_entity.magma_crucible.TileCrucibleController;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MagmaCrucibleStructureBlock extends Block implements IMagmaCrucibleStructureBlock{

	public final int type;
	public MagmaCrucibleStructureBlock(String name,int type) {
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
	public void setMaster(BlockPos pos, World world, BlockPos master) {
	}
	@Override
	public boolean hasMaster(BlockPos pos, World world) {
		return false;
	}
	@Override
	public void clearMaster(BlockPos pos, World world) {
	}
	@Override
	public BlockPos getMaster(BlockPos pos, World world) {
		return null;
	}
	@Override
	public int getType(BlockPos pos, World world) {
		return type;
	}
	

}
