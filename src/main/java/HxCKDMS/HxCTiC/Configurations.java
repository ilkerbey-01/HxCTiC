package HxCKDMS.HxCTiC;

import HxCKDMS.HxCCore.api.Configuration.Config;
import HxCKDMS.HxCTiC.lib.HxCMaterial;
import net.minecraft.util.EnumChatFormatting;

import java.util.HashMap;

@Config
@SuppressWarnings("all")
public class Configurations {
    public static HashMap<String, HxCMaterial> materials = new HashMap<String, HxCMaterial>(){{
        //Proof of concept before I sleep, OP as fuck not gonna really exist...
        putIfAbsent("Potato", new HxCMaterial(500, "potato", 5000, 30, 5, 15, 5.0f, 4, 1, 10, 1, 1, 0.1f, EnumChatFormatting.YELLOW.toString(), 0xffffff00));
    }};
}
