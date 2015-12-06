package evercraft.NEMESIS13cz.Items.Misc;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;


public class ItemConductanceCoil extends Item {
public ItemConductanceCoil() {
setCreativeTab(ECTabs.tabECMisc); //Tells the game what creative mode tab it goes in
}

public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
{
    if (p_77648_7_ == 0)
    {
        --p_77648_5_;
    }

    if (p_77648_7_ == 1)
    {
        ++p_77648_5_;
    }

    if (p_77648_7_ == 2)
    {
        --p_77648_6_;
    }

    if (p_77648_7_ == 3)
    {
        ++p_77648_6_;
    }

    if (p_77648_7_ == 4)
    {
        --p_77648_4_;
    }

    if (p_77648_7_ == 5)
    {
        ++p_77648_4_;
    }

    if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
    {
        return false;
    }
    else
    {
        if (p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_, p_77648_6_))
        {
            p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, Evercraft_Blocks.blockConductanceCoil);
            --p_77648_1_.stackSize;
        }
        return true;
    }
}


@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.COIL);
}
}