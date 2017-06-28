package joharker.growindesert.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.BlockSapling;
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
				Random r = new Random();
				if (r.nextFloat() < GrowInDesertMod.CHANCE_TO_GROWING)
				{
					IBlockState dirt = Blocks.DIRT.getDefaultState();
					IBlockState sapling = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE,
							EnumType.ACACIA);

					BlockPos under = event.getPos().add(0, -1.0, 0);

					if (event.getWorld().getBlockState(under).getBlock() == Blocks.SAND)
					{
						event.getWorld().setBlockState(under, dirt);
					}

					event.getWorld().setBlockState(event.getPos(), sapling);
				}
				event.setResult(Result.ALLOW);
			}
		}
	}
}
