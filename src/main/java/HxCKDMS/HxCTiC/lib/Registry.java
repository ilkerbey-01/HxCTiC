package HxCKDMS.HxCTiC.lib;

import HxCKDMS.HxCTiC.RGBFluid;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class Registry {
    public static HashMap<String, Fluid> fluids = new HashMap<>();
    public static HashMap<String, Block> leFluids = new HashMap<>();

    public static void preinit() {
        Configurations.materials.keySet().forEach(mat ->
                fluids.putIfAbsent("fluid_" + mat.toLowerCase(), new Fluid("fluid_" + mat.toLowerCase())));
    }

    public static void init () {
        fluids.forEach((name, fluid) -> {
            fluid.setTemperature(400);
            fluid.setViscosity(4);
            fluid.setDensity(3);
            FluidRegistry.registerFluid(fluid);
            Block lef = new RGBFluid(fluid, Configurations.materials.get(StringUtils.capitalize(name.substring(6))).Colour).setBlockName(name);
            leFluids.putIfAbsent(name, lef);
            GameRegistry.registerBlock(lef, Reference.MOD_ID + "_fluid_" + name);
            fluid.setUnlocalizedName(lef.getUnlocalizedName());
        });
    }
}
