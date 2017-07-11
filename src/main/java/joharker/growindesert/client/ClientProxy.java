package joharker.growindesert.client;

import joharker.growindesert.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}

	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		// Register color handlers
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new WoodColorizer(), Blocks.LOG);
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new WoodColorizer(), Blocks.LOG2);
	}

	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
}
