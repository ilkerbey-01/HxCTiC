package HxCKDMS.HxCTiC;

import HxCKDMS.HxCCore.HxCCore;
import HxCKDMS.HxCCore.api.Configuration.Handlers.SpecialHandlers;
import HxCKDMS.HxCCore.api.Configuration.HxCConfig;
import HxCKDMS.HxCTiC.lib.Configurations;
import HxCKDMS.HxCTiC.lib.HxCMaterial;
import HxCKDMS.HxCTiC.lib.Registry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import static HxCKDMS.HxCTiC.lib.Reference.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = VERSION, dependencies = DEPENDENCIES)
public class HxCTiC {
    @Instance(MOD_ID)
    public static HxCTiC instance;

    public HxCConfig hxCConfig;
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        SpecialHandlers.registerSpecialClass(HxCMaterial.class);
        hxCConfig = new HxCConfig(Configurations.class, "HxCTiC", HxCCore.HxCConfigDir, "cfg", MOD_ID);
        hxCConfig.initConfiguration();
/*
        String[] a = new String[4];
        String[] b = new String[4];*/
        /*String[] c = new String[]{
                "ingot", "rod", "pickaxe", "shovel", "axe", "swordblade", "largeguard", "mediumguard", "crossbar",
                "binding", "frypan", "sign", "knifeblade", "chisel", "largerod", "toughbinding", "largeplate",
                "broadaxe", "scythe", "excavator", "largeblade", "hammerhead", "fullguard", "bowstring",
                "fletching", "arrowhead", "gem", "nugget"
        };*/
       /* {
            a[0] = "string";
            a[1] = "enchantedfabric";
            a[2] = "flamestring";
            a[3] = "potatostring";

            b[0] = "string";
            b[1] = "magicfabric";
            b[2] = "flamestring";
            b[3] = "potatostring";
        }*/

        /*HxCReflectionHandler.setPrivateFinalValue(Bowstring.class, null, a, "toolMaterialNames", "toolMaterialNames");
        HxCReflectionHandler.setPrivateFinalValue(Bowstring.class, null, b, "toolTextureNames", "toolTextureNames");*/
        /*HxCReflectionHandler.setPrivateFinalValue(MetalPattern.class, null, c, "patternName", "patternName");*/

        Registry.preinit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Registry.init();
        Configurations.materials.values().forEach(HxCMaterial::init);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}
