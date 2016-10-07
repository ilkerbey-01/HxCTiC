package HxCKDMS.HxCTiC.lib;

import HxCKDMS.HxCCore.Configs.Configurations;
import HxCKDMS.HxCCore.api.Utils.LogHelper;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

@SuppressWarnings("WeakerAccess")
public class HxCMaterial {
    public int MaterialID;
    public String MaterialName = "";
    public String LocalizationString = "";
    public int Durability;
    public int MiningSpeed;
    public int HarvestLevel;
    public int AttackDamage;
    public float HandleDurabilityModifier;
    public int ReinforcementLevel;
    public int StoneboundLevel;
    public float ProjectileSpeed;
    public int BowDrawSpeed;
    public float ProjectileMass;
    public float ProjectileFragility;
    public String Style = EnumChatFormatting.WHITE.toString();
    public int Colour = 0xFFFFFFFF;
    public HxCMaterial () {}

    public HxCMaterial (int id, String name, int durability, int miningSpeed, int miningLevel, int attack, float durabilityMod, int reinforcement, int stonebound, float projSpeed, int drawSpeed, float mass, float fragility, String style, int color) {
        MaterialID = id;
        MaterialName = name;
        LocalizationString = "material.hxctic." + name.toLowerCase();
        Durability = durability;
        MiningSpeed = miningSpeed;
        HarvestLevel = miningLevel;
        AttackDamage = attack;
        HandleDurabilityModifier = durabilityMod;
        ReinforcementLevel = reinforcement;
        StoneboundLevel = stonebound;
        ProjectileSpeed = projSpeed;
        BowDrawSpeed = drawSpeed;
        ProjectileMass = mass;
        ProjectileFragility = fragility;
        Style = style;
        Colour = color;
        if (Configurations.DebugMode)
            LogHelper.info(String.format("Registered material : %1$s with traits : ID = %2$s , Name = %3$s , Durability = %4$s , MiningSpeed = %5$s , MiningLevel = %6$s , AttackDamage = %7$s , DurabilityToolModifier = %8$s , ReinforcementLevel = %9$s , StoneboundLevel = %10$s , ProjectileSpeed = %11$s , DrawSpeed = %12$s , Mass = %13$s , Fragility = %14$s", name, id, name, durability, miningSpeed, miningLevel, attack, durabilityMod, reinforcement, stonebound, projSpeed, drawSpeed, mass, fragility), Reference.MOD_ID);
    }

    public void init() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("Id", MaterialID);
        tag.setString("Name", MaterialName);
        tag.setString("localizationString", LocalizationString);
        tag.setInteger("Durability", Durability);
        tag.setInteger("MiningSpeed", MiningSpeed);
        tag.setInteger("HarvestLevel", HarvestLevel);
        tag.setInteger("Attack", AttackDamage);
        tag.setFloat("HandleModifier", HandleDurabilityModifier);
        tag.setInteger("Reinforced", ReinforcementLevel);
        tag.setInteger("Stonebound", StoneboundLevel);
        if (BowDrawSpeed != 0) {
            tag.setFloat("Bow_ProjectileSpeed", ProjectileSpeed);
            tag.setInteger("Bow_DrawSpeed", BowDrawSpeed);
        }
        if (ProjectileMass != 0) {
            tag.setFloat("Projectile_Mass", ProjectileMass);
            tag.setFloat("Projectile_Fragility", ProjectileFragility);
        }
        tag.setString("Style", Style);
        tag.setInteger("Color", Colour);
        FMLInterModComms.sendMessage("TConstruct", "addMaterial", tag);
    }
}
