package com.YTrollman.CompressedChorusFruit.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CompressedChorusFruitConfig {

    public static ForgeConfigSpec.IntValue COMPRESSED_CHORUS_FRUIT_MAX_X_RANGE;
    public static ForgeConfigSpec.IntValue COMPRESSED_CHORUS_FRUIT_MAX_Y_RANGE;
    public static ForgeConfigSpec.IntValue COMPRESSED_CHORUS_FRUIT_MAX_Z_RANGE;

    public static ForgeConfigSpec.IntValue COMPRESSED_CHORUS_FRUIT_COOLDOWN;


    public static void init(ForgeConfigSpec.Builder common) {

            common.comment("Compressed Chorus Fruit Options");

            COMPRESSED_CHORUS_FRUIT_MAX_X_RANGE = common
            		.comment("\nCompressed Chorus Fruit Max X Range")
                    .defineInRange("compressedChorusFruitMaxXRange", 3000000, 1, Integer.MAX_VALUE);

            COMPRESSED_CHORUS_FRUIT_MAX_Y_RANGE = common
                    .comment("\nCompressed Chorus Fruit Max Y Range")
                    .defineInRange("compressedChorusFruitMaxYRange", 100, 1, Integer.MAX_VALUE);

            COMPRESSED_CHORUS_FRUIT_MAX_Z_RANGE = common
                    .comment("\nCompressed Chorus Fruit Max Z Range")
                    .defineInRange("compressedChorusFruitMaxZRange", 3000000, 1, Integer.MAX_VALUE);

            COMPRESSED_CHORUS_FRUIT_COOLDOWN = common
                    .comment("\nCompressed Chorus Fruit Max Cooldown")
                    .defineInRange("compressedChorusFruitCooldown", 36000, 1, Integer.MAX_VALUE);
    }
}
