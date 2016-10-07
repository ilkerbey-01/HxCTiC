package HxCKDMS.HxCTiC.lib;

import HxCKDMS.HxCCore.api.Configuration.Config;
import net.minecraft.util.EnumChatFormatting;

import java.util.HashMap;

@Config
@SuppressWarnings("all")
public class Configurations {
    public static HashMap<String, HxCMaterial> materials = new HashMap<String, HxCMaterial>(){{
        //Proof of concept before I sleep, OP as fuck not gonna really exist...
        putIfAbsent("Potato", new HxCMaterial(500, "potato", 5000, 30, 5, 15, 5.0f, 4, 1, 10, 1, 1, 0.1f, EnumChatFormatting.YELLOW.toString(), 0xffffff00, "cropPotato", 1, false));
        putIfAbsent("Carrot", new HxCMaterial(501, "carrot", 50, 10, 7, 5, 10.0f, 2, 1, 10, 1, 1, 0.1f, EnumChatFormatting.GOLD.toString(), 0xffffCC00, "cropCarrot", 1, false));
        putIfAbsent("Quartz", new HxCMaterial(502, "quartz", 50, 10, 4, 25, 1.5f, 2, 1, 10, 1, 1, 0.1f, EnumChatFormatting.GRAY.toString(), 0xffCCCCCC, "gemQuartz", 1, false));
    }};
}
