package joharker.growindesert;
import java.awt.Color;

public class Constants
{
	public static final String MODID = "growindesert";
	public static final String VERSION = "0.4";

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
	
	public static final Color WOOD_COLOR_MULTIPLIER = new Color(240, 228, 186);// Colorize wood in desert by dry tints
}
