package evercraft.NEMESIS13cz.misc;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Machines;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldAditional;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldBase;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldMegaVeins;
 
public class ConfigGui extends GuiConfig {
	
    public ConfigGui(GuiScreen parent) {
        super(parent, getConfigElements(), ModInformation.ID, "EvercraftConfigurationIDWhatever", false, false, "/.minecraft/config/Evercraft/. . .");
    }
    
    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        List<IConfigElement> list_base = new ArrayList<IConfigElement>();
        List<IConfigElement> list_machines = new ArrayList<IConfigElement>();
        List<IConfigElement> list_worldBase = new ArrayList<IConfigElement>();
        List<IConfigElement> list_worldAditional = new ArrayList<IConfigElement>();
        List<IConfigElement> list_worldMegaVeins = new ArrayList<IConfigElement>();
        
        list_base.addAll(new ConfigElement(Evercraft_Config_Base.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());
        list_machines.addAll(new ConfigElement(Evercraft_Config_Machines.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());
        list_worldBase.addAll(new ConfigElement(Evercraft_Config_WorldBase.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());
        list_worldAditional.addAll(new ConfigElement(Evercraft_Config_WorldAditional.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());
        list_worldMegaVeins.addAll(new ConfigElement(Evercraft_Config_WorldMegaVeins.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());
        
        list.add(new DummyCategoryElement("Base", "evercraft.config.base", list_base).setRequiresMcRestart(true));
        list.add(new DummyCategoryElement("Machines", "evercraft.config.machines", list_machines));
        list.add(new DummyCategoryElement("World - Base", "evercraft.config.world_base", list_worldBase));
        list.add(new DummyCategoryElement("World - Aditional", "evercraft.config.world_aditional", list_worldAditional));
        list.add(new DummyCategoryElement("World - Crazy", "evercraft.config.world_crazy", list_worldMegaVeins));
        
        return list;
    }
}