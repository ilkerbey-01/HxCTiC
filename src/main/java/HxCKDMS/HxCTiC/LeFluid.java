package HxCKDMS.HxCTiC;

import HxCKDMS.HxCTiC.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class LeFluid extends BlockFluidBase {
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public int colour = 0xffffffff;

    @Override
    public int getRenderType() {
        return Reference.BLOCK_RENDER_ID;
    }

    public LeFluid(Fluid fluid, int color) {
        super(fluid, Material.lava);
        setCreativeTab(CreativeTabs.tabMisc);
        colour = color;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(Reference.MOD_ID + ":fluidStill");
        flowingIcon = register.registerIcon(Reference.MOD_ID + ":fluidFlowing");
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.displaceIfPossible(world, x, y, z);
    }

    @Override
    public int getQuantaValue(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x, y, z) == Blocks.air)
            return 0;

        if (world.getBlock(x, y, z) != this)
            return -1;

        return quantaPerBlock - world.getBlockMetadata(x, y, z);
    }

    @Override
    public boolean canCollideCheck(int meta, boolean fullHit) {
        return false;
    }

    @Override
    public int getMaxRenderHeightMeta() {
        return 0;
    }

    @Override
    public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
        return null;
    }

    @Override
    public boolean canDrain(World world, int x, int y, int z) {
        return false;
    }
}
