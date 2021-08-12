package com.YTrollman.CompressedChorusFruit.config;

import java.io.File;

import com.YTrollman.CompressedChorusFruit.CompressedChorusFruit;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {

	private static final ForgeConfigSpec.Builder common_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec common_config;
	
	static
	{
		CompressedChorusFruitConfig.init(common_builder);
		common_config = common_builder.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		CompressedChorusFruit.LOGGER.info("Loading config: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		CompressedChorusFruit.LOGGER.info("Built config: " + path);
		file.load();
		CompressedChorusFruit.LOGGER.info("Loaded config: " + path);
		config.setConfig(file);
	}
}