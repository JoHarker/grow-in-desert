package joharker.growindesert.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;

import joharker.growindesert.GrowInDesertMod;

@Mod.EventBusSubscriber
public class BonemealEventHandler
{
	@SubscribeEvent
	public static void BonemealEvent(BonemealEvent event)
	{
		if (event.getWorld().isRemote == false)
		{
			if (event.getBlock().getBlock() == Blocks.DEADBUSH)
			{
				float growingChanceIncrease;
				float saplingChanceIncrease;
				// To count water source blocks in area
				{
					final int AREA_WIDTH = 9;
					final int AREA_HEIGHT = 9;
					int countBlocks = 0;
					BlockPos pos = // move origin to left upper corner
							event.getPos().add(-AREA_WIDTH / 2, 0, -AREA_HEIGHT / 2);
					for (int y = 0; y < 2; y++, pos = pos.add(0, -1, 0))
					{
						for (int x = 0; x < AREA_WIDTH; x++, pos = pos.add(1, 0, 0))
						{
							for (int z = 0; z < AREA_HEIGHT; z++, pos = pos.add(0, 0, 1))
							{
								if (event.getWorld().getBlockState(pos).getBlock() == Blocks.WATER)
								{
									countBlocks++;
								}
							}
							pos = pos.add(0, 0, -AREA_HEIGHT);
						}
						pos = pos.add(-AREA_WIDTH, 0, 0);
					}

					// Calculate probability increase depending on water blocks count

					growingChanceIncrease =
							// Using square root function to better smooth
							// of relation - number of water blocks to chance
							(float) (GrowInDesertMod.CHANCE_INCREMENT_WITH_WATER__GROWING * Math.sqrt(countBlocks));

					saplingChanceIncrease = // Using linear function. One block add constant value
							GrowInDesertMod.CHANCE_INCREMENT_WITH_WATER__SAPLING * countBlocks;
				}

				Random r = new Random();
				// Growing random check
				if (r.nextFloat() < GrowInDesertMod.CHANCE_TO_GROWING + growingChanceIncrease)
				{
					IBlockState plant;
					float saplingChance = GrowInDesertMod.CHANCE_TO_GROWING_SAPLING + saplingChanceIncrease;
					float grassChance = (1.0f - saplingChance) / 2.0f;
					// fernChance = remain probability
					// Plants random check
					float randomCheck = r.nextFloat();
					if (randomCheck < saplingChance)
					{// choose sapling
						plant = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE,
								BlockPlanks.EnumType.ACACIA);
					} else if (randomCheck < saplingChance + grassChance)
					{// choose grass
						plant = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE,
								BlockTallGrass.EnumType.GRASS);
					} else
					{// choose fern
						plant = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE,
								BlockTallGrass.EnumType.FERN);
					}

					BlockPos under = event.getPos().add(0, -1, 0);
					event.getWorld().setBlockState(under, Blocks.GRASS.getDefaultState());
					event.getWorld().setBlockState(event.getPos(), plant);
				}

				// takes one bone meal from player
				event.setResult(Result.ALLOW);

			} // end of 'if dead bush'
		}
	}
}
