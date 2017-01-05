package NuclearFoundation.world_gen;

import java.util.Random;

import NuclearFoundation.blocks.BlockRegistry;
import NuclearFoundation.core.Config;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator{

	public WorldGenerator Bauxite;
	public WorldGenerator Ilmenite;
	public WorldGenerator Chromite;
	public WorldGenerator Pyrite;
	public WorldGenerator Cobaltite;
	public WorldGenerator Garnierite;
	public WorldGenerator Copper;
	public WorldGenerator Malachite;
	public WorldGenerator Sphalerite;
	public WorldGenerator ArsenoPyrite;
	public WorldGenerator Silver;
	public WorldGenerator Cassiterite;
	public WorldGenerator Wolframite;
	public WorldGenerator Platinum;
	public WorldGenerator Galena;
	public WorldGenerator Cinnabar;
	public WorldGenerator Bismuthinite;
	public WorldGenerator Orichalcum;
	public WorldGenerator Thorite;
	public WorldGenerator Pitchblende;
	
	public WorldGenerator Ruby;
	public WorldGenerator TigerEye;
	public WorldGenerator Sapphire;
	public WorldGenerator Amethist;
	
	public WorldGenerator N_Pyrite;
	public WorldGenerator N_arsenoPyrite;
	public WorldGenerator N_Silver;
	public WorldGenerator N_Gold;
	public WorldGenerator N_Cinnabar;
	public WorldGenerator N_Prometheum;
	public WorldGenerator N_Mithril;
	public WorldGenerator N_Sulfur;
	public WorldGenerator N_Diamond;
	public WorldGenerator N_Blazonium;
	
	public WorldGenerator E_Terminium;
	public WorldGen() {
		Bauxite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(0), 9);
		Ilmenite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(1), 5);
		Chromite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(2), 5);
		Pyrite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(6), 9);
		Cobaltite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(7), 5);
		Garnierite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(8), 9);
		Copper=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(9), 9);
		Malachite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(10), 9);
		Sphalerite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(11), 9);
		ArsenoPyrite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(12), 5);
		Silver=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(14), 9);
		Cassiterite=new WorldGenMinable(BlockRegistry.OreBlock0.getStateFromMeta(15), 9);
		Wolframite=new WorldGenMinable(BlockRegistry.OreBlock1.getStateFromMeta(0), 5);
		Platinum=new WorldGenMinable(BlockRegistry.OreBlock1.getStateFromMeta(1), 5);
		Galena=new WorldGenMinable(BlockRegistry.OreBlock1.getStateFromMeta(4), 9);
		Cinnabar=new WorldGenMinable(BlockRegistry.OreBlock1.getStateFromMeta(3), 9);
		Bismuthinite=new WorldGenMinable(BlockRegistry.OreBlock1.getStateFromMeta(5), 9);
		Orichalcum=new WorldGenMinable(BlockRegistry.OreBlock1.getStateFromMeta(6), 8);
		Thorite=new WorldGenMinable(BlockRegistry.ThoriumOre.getDefaultState(), 5);
		Pitchblende=new WorldGenMinable(BlockRegistry.UraniumOre.getDefaultState(), 5);
		//nether
		N_Pyrite=new WorldGenMinable(BlockRegistry.NetherOreBlock0.getStateFromMeta(0), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_arsenoPyrite=new WorldGenMinable(BlockRegistry.NetherOreBlock0.getStateFromMeta(1), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_Silver=new WorldGenMinable(BlockRegistry.NetherOreBlock0.getStateFromMeta(2), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_Gold=new WorldGenMinable(BlockRegistry.NetherOreBlock0.getStateFromMeta(3), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_Cinnabar=new WorldGenMinable(BlockRegistry.NetherOreBlock0.getStateFromMeta(4), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_Prometheum=new WorldGenMinable(BlockRegistry.NetherOreBlock0.getStateFromMeta(5), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_Mithril=new WorldGenMinable(BlockRegistry.NetherOreBlock0.getStateFromMeta(6), 5, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_Sulfur=new WorldGenMinable(BlockRegistry.NetherOreBlock1.getStateFromMeta(1), 17, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_Diamond=new WorldGenMinable(BlockRegistry.NetherOreBlock1.getStateFromMeta(2), 7, BlockMatcher.forBlock(Blocks.NETHERRACK));
		N_Blazonium=new WorldGenMinable(BlockRegistry.BlazoniumOre.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.NETHERRACK));
		//end
		E_Terminium=new WorldGenMinable(BlockRegistry.TerminiumOre.getDefaultState(), 7, BlockMatcher.forBlock(Blocks.END_STONE));
	}
	
	@Override
	public void generate(Random rand, int chunk_X, int chunk_Z, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		case(-1):{
			//nether
			runGenerator(N_Pyrite, world, rand, chunk_X, chunk_Z, Config.Npyrite, 1, 125);
			runGenerator(N_arsenoPyrite, world, rand, chunk_X, chunk_Z, Config.Narsenopyrite, 1, 125);
			runGenerator(N_Silver, world, rand, chunk_X, chunk_Z, Config.Nsilver, 1, 125);
			runGenerator(N_Gold, world, rand, chunk_X, chunk_Z, Config.Ngold, 1, 125);
			runGenerator(N_Cinnabar, world, rand, chunk_X, chunk_Z, Config.Ncinnabar, 1, 125);
			runGenerator(N_Prometheum, world, rand, chunk_X, chunk_Z, Config.Nprometheum, 1, 125);
			runGenerator(N_Mithril, world, rand, chunk_X, chunk_Z, Config.Nmithril, 1, 125);
			runGenerator(N_Sulfur, world, rand, chunk_X, chunk_Z, Config.Nsulfur, 1, 125);
			runGenerator(N_Diamond, world, rand, chunk_X, chunk_Z, Config.Ndiamond, 1, 125);
			runGenerator(N_Blazonium, world, rand, chunk_X, chunk_Z, Config.Nblazonium, 1, 125);
			break;
		}
		case(1):{
			//end
			runGenerator(E_Terminium, world, rand, chunk_X, chunk_Z, 6, Config.terminium, 250);
			break;
		}
		case(0):{
			
		}
		default:{
			runGenerator(Bauxite, world, rand, chunk_X, chunk_Z, Config.Bauxite, 1, 64);
			runGenerator(Ilmenite, world, rand, chunk_X, chunk_Z, Config.Ilmenite, 1, 32);
			runGenerator(Chromite, world, rand, chunk_X, chunk_Z, Config.Chromite, 1, 48);
			runGenerator(Pyrite, world, rand, chunk_X, chunk_Z, Config.Pyrite, 1, 32);
			runGenerator(Cobaltite, world, rand, chunk_X, chunk_Z, Config.Cobaltite, 1, 48);
			runGenerator(Copper, world, rand, chunk_X, chunk_Z, Config.Copper/2, 16, 125);
			runGenerator(Malachite, world, rand, chunk_X, chunk_Z, Config.Copper/2, 16, 125);
			runGenerator(Sphalerite, world, rand, chunk_X, chunk_Z, Config.Sphalerite, 48, 125);
			runGenerator(ArsenoPyrite, world, rand, chunk_X, chunk_Z, Config.Arsenopyrite, 8, 16);
			runGenerator(Silver, world, rand, chunk_X, chunk_Z, Config.Silver, 1, 40);
			runGenerator(Cassiterite, world, rand, chunk_X, chunk_Z, Config.Cassiterite, 32, 125);
			runGenerator(Wolframite, world, rand, chunk_X, chunk_Z, Config.Wolframite, 1, 24);
			runGenerator(Platinum, world, rand, chunk_X, chunk_Z, Config.Platinum, 1, 32);
			runGenerator(Galena, world, rand, chunk_X, chunk_Z, Config.Galena, 1, 32);
			runGenerator(Cinnabar, world, rand, chunk_X, chunk_Z, Config.Cinnabar, 16, 48);
			runGenerator(Bismuthinite, world, rand, chunk_X, chunk_Z, Config.Bismuthinite, 16, 48);
			runGenerator(Orichalcum, world, rand, chunk_X, chunk_Z, Config.Orichalcum, 100, 250);
			runGenerator(Thorite, world, rand, chunk_X, chunk_Z, Config.Thorite, 1, 40);
			runGenerator(Pitchblende, world, rand, chunk_X, chunk_Z, Config.Pitchblende, 1, 40);
			break;
		}
		}
		
	}
	public void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}

}
