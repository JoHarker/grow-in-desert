package joharker.growindesert;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = GrowInDesertMod.MODID, version = GrowInDesertMod.VERSION)
public class GrowInDesertMod
{
	public static final String MODID = "growindesert";
	public static final String VERSION = "0.3";

	public static final float CHANCE_TO_GROWING;// Chance that bone meal will take effect
	public static final float CHANCE_INCREMENT_WITH_WATER__GROWING;
	static
	{
		CHANCE_TO_GROWING = 0.10f;

		final int n = 10;// Number of blocks needed to absolute chance
		CHANCE_INCREMENT_WITH_WATER__GROWING = // Using square root function
				// to better smooth of relation - number of water blocks to chance
				(float) ((1.0f - CHANCE_TO_GROWING) / Math.sqrt((double) n));
	}

	public static final float CHANCE_TO_GROWING_SAPLING = 0.3f;// Chance that result will be sapling
	public static final float CHANCE_INCREMENT_WITH_WATER__SAPLING = 0.1f;// Linear increment
}
