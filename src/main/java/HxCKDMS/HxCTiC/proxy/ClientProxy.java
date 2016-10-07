package HxCKDMS.HxCTiC.proxy;

import HxCKDMS.HxCTiC.FluidRenderer;
import HxCKDMS.HxCTiC.lib.Reference;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy {
    @Override
    public void preInit() {
        Reference.BLOCK_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(Reference.BLOCK_RENDER_ID, new FluidRenderer());
    }

    @Override
    public void init() {}

    @Override
    public void postInit() {}
}
