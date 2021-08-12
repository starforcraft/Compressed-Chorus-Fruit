package com.YTrollman.CompressedChorusFruit;

import com.YTrollman.CompressedChorusFruit.config.Config;
import com.YTrollman.CompressedChorusFruit.registry.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("compressedchorusfruit")
public class CompressedChorusFruit
{
    public static final String MOD_ID = "compressedchorusfruit";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    
    public CompressedChorusFruit() {
        RegistryHandler.init();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.common_config);
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Config.loadConfig(Config.common_config, FMLPaths.CONFIGDIR.get().resolve("compressedchorusfruit-common.toml").toString());
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
    	
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
    	
    }
}
