package com.YTrollman.CompressedChorusFruit.registry;

import com.YTrollman.CompressedChorusFruit.CompressedChorusFruit;
import com.YTrollman.CompressedChorusFruit.items.CompressedChorusFruitItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CompressedChorusFruit.MOD_ID);

    public static final RegistryObject<Item> COMPRESSED_CHORUS_FRUIT = ITEMS.register("compressed_chorus_fruit", () -> new CompressedChorusFruitItem(new Item.Properties().tab(ItemGroupCompressedChorusFruit.COMPRESSED_CHORUS_FRUIT).food(ModFoods.COMPRESSED_CHORUS_FRUIT)));
}