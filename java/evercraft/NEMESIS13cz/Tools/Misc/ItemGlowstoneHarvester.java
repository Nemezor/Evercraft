package evercraft.NEMESIS13cz.Tools.Misc;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemGlowstoneHarvester extends Item {
public ItemGlowstoneHarvester() {
setCreativeTab(ECTabs.tabECTools);
this.maxStackSize = 1;
this.setMaxDamage(Evercraft_Config_Base.glowstoneharvesterUSES);
}

public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
    par3.add("Uses: " + (this.getMaxDamage() - this.getDamage(par1)));
}

public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
{
    if (!par2EntityPlayer.canPlayerEdit(x, y, z, par7, par1ItemStack))
    {
        return false;
    }
    else
    {
        UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, x, y, z);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        }
        Block i1 = par3World.getBlock(x, y, z);

        if (i1 != Blocks.glowstone)
        {
            return false;
        }
        else
        {
            if (par3World.isRemote)
            {
                return true;
            }
            else
            {
            	if (i1 == Blocks.glowstone) {
            	par3World.setBlock(x, y, z, Blocks.air);
        		ItemStack DROP = new ItemStack(Items.glowstone_dust,4);
        		Entity ItemDROP = new EntityItem(par3World, x, y, z, DROP);
        		par3World.spawnEntityInWorld(ItemDROP);
                par1ItemStack.damageItem(1, par2EntityPlayer);
            	}
            }
                return true;
            }
        
        }
}


@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.GLOWSTONE_HARVESTER);
}
}