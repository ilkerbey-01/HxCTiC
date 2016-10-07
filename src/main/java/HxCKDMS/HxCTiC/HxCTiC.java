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
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import static HxCKDMS.HxCTiC.lib.Reference.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = VERSION, dependencies = DEPENDENCIES)
public class HxCTiC {

    @Instance(MOD_ID)
    public static HxCTiC instance;
    public static SimpleNetworkWrapper networkWrapper = new SimpleNetworkWrapper(CHANNEL_NAME);

    public HxCConfig hxCConfig;
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        SpecialHandlers.registerSpecialClass(HxCMaterial.class);
        hxCConfig = new HxCConfig(Configurations.class, "HxCTiC", HxCCore.HxCConfigDir, "cfg", MOD_ID);
        hxCConfig.initConfiguration();
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
