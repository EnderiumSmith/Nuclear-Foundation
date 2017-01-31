package NuclearFoundation.blocks;

import java.util.Random;

import NuclearFoundation.core.MethodUtil;
import NuclearFoundation.fluids.FluidManager;
import NuclearFoundation.items.CustomCreativeTabs;
import net.minecraft.block.BlockIce;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockDryIce extends BlockIce{
	
	public BlockDryIce() {
		super();
		setRegistryName("dry_ice");
		setUnlocalizedName(getRegistryName().toString());
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
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if(entityIn instanceof EntityLivingBase){
			MethodUtil.dealFreezeDamage((EntityLivingBase)entityIn, 1);
		}
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (worldIn.getLightFor(EnumSkyBlock.BLOCK, pos) > 11 - this.getDefaultState().getLightOpacity()){
			worldIn.setBlockState(pos, FluidManager.CO2b.getDefaultState());
			worldIn.notifyNeighborsOfStateChange(pos, FluidManager.CO2b);
		}
	}
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te,
			ItemStack stack) {
		player.addStat(StatList.getBlockStats(this));
        player.addExhaustion(0.025F);

        if (this.canSilkHarvest(worldIn, pos, state, player) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0)
        {
            java.util.List<ItemStack> items = new java.util.ArrayList<ItemStack>();
            ItemStack itemstack = this.createStackedBlock(state);

            if (itemstack != null)
            {
                items.add(itemstack);
            }

            net.minecraftforge.event.ForgeEventFactory.fireBlockHarvesting(items, worldIn, pos, state, 0, 1.0f, true, player);
            for (ItemStack is : items)
                spawnAsEntity(worldIn, pos, is);
        }
        else
        {
        	worldIn.setBlockState(pos, FluidManager.CO2b.getDefaultState());
        }
	}
}
