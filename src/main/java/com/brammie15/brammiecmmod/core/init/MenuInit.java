package com.brammie15.brammiecmmod.core.init;


import com.brammie15.brammiecmmod.CmMod;
import com.brammie15.brammiecmmod.common.block.cm_centrifuge_new.NewCmCentrifugeContainerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MenuInit {
    private MenuInit(){}

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CmMod.MOD_ID);

    public static final RegistryObject<MenuType<NewCmCentrifugeContainerMenu>> CM_CENTRIFUGE_MENU = MENUS.register("cm_centrifuge_menu",
            () -> new MenuType<>(NewCmCentrifugeContainerMenu::new));


}
