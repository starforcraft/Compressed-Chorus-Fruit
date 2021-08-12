package com.YTrollman.CompressedChorusFruit.registry;

import com.YTrollman.CompressedChorusFruit.CompressedChorusFruit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class ItemGroupCompressedChorusFruit {

	public static final ItemGroup COMPRESSED_CHORUS_FRUIT = (new ItemGroup(CompressedChorusFruit.MOD_ID) {

		@Override
		@Nonnull
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.COMPRESSED_CHORUS_FRUIT.get());
		}
	});
	
}
