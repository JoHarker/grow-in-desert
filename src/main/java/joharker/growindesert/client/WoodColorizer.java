package joharker.growindesert.client;

import joharker.growindesert.DefaultValues;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class WoodColorizer implements IBlockColor
{
	@Override
    public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex)
    {
    	if (worldIn != null && pos != null
    			&& worldIn.getBiome(pos).getTemperature() >= 2.0f)
        {
    		return DefaultValues.WOOD_COLOR_MULTIPLIER.getRGB();
        }
    	else
    		return -1;
    }
}