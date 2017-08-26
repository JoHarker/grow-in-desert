package joharker.growindesert.common;

import java.util.HashSet;

import joharker.growindesert.DefaultValues;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{

	}

	public void init(FMLInitializationEvent event)
	{
		final IBlockState acaciaSapling = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE,
				BlockPlanks.EnumType.ACACIA);
		final IBlockState birchSapling = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE,
				BlockPlanks.EnumType.BIRCH);
		final IBlockState darkOakSapling = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE,
				BlockPlanks.EnumType.DARK_OAK);
		final IBlockState jungleSapling = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE,
				BlockPlanks.EnumType.JUNGLE);
		final IBlockState oakSapling = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE,
				BlockPlanks.EnumType.OAK);
		final IBlockState spruceSapling = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE,
				BlockPlanks.EnumType.SPRUCE);

		// Chance to get a sapling by using bone meal on the grass block;
		for (Biome b : ForgeRegistries.BIOMES)
		{
			if (b.getBiomeName().equals("Hell") || b.getBiomeName().equals("The End"))
				continue;

			HashSet<IBlockState> saplingsToAdd = new HashSet<>();
			float t = b.getTemperature();

			float e = 0.0001f;// Using to include bounds
			if (Float.compare(t, -e) > 0 && Float.compare(t, 2f + e) < 0)
				saplingsToAdd.add(oakSapling);
			if (Float.compare(t, -0.5f - e) > 0 && Float.compare(t, 0.3f + e) < 0)
				saplingsToAdd.add(spruceSapling);
			if (Float.compare(t, 0.6f - e) > 0 && Float.compare(t, 0.7f + e) < 0)
				saplingsToAdd.add(birchSapling);
			if (Float.compare(t, 0.95f) == 0)
				saplingsToAdd.add(jungleSapling);
			if ((Float.compare(t, 1.1f - e) > 0 && Float.compare(t, 1.2f + e) < 0) || Float.compare(t, 2f) == 0)
				saplingsToAdd.add(acaciaSapling);

			if (b.getBiomeName().equals("Roofed Forest"))
				saplingsToAdd.add(darkOakSapling);

			if (saplingsToAdd.size() == 0)
				saplingsToAdd.add(oakSapling);
			
			int chanceWeight = // Divides chance between all saplings
					DefaultValues.GRASS_BLOCK.SAPLING_CHANCE_WEIGHT / saplingsToAdd.size();
			if (chanceWeight == 0)
				chanceWeight = 1;

			for (IBlockState sapling : saplingsToAdd)
			{
				b.addFlower(sapling, chanceWeight);
			}
		}
	}

	public void postInit(FMLPostInitializationEvent event)
	{

	}
}
