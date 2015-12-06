package evercraft.NEMESIS13cz.Tools.Misc;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Main.ECTabs;


public class ItemWoolCard extends Item {
public ItemWoolCard() {
setCreativeTab(ECTabs.tabECTools);
this.maxStackSize = 1;
this.setMaxDamage(Evercraft_Config_Base.woolcardUSES);
}

public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
    par3.add("Uses: " + (this.getMaxDamage() - this.getDamage(par1)));
}

public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase entitylivingbase)
{
        Block i1 = world.getBlock(x, y, z);

        if (i1 != Blocks.wool)
        {
    		itemstack.damageItem(1, entitylivingbase);
            return false;
        }
        else
        {
            if (world.isRemote)
            {
                return true;
            }
            else
            {
            	if (i1 == Blocks.wool) {
            	world.setBlock(x, y, z, Blocks.air);
        		ItemStack DROP = new ItemStack(Items.string, 4);
        		Entity ItemDROP = new EntityItem(world, x, y, z, DROP);
        		world.spawnEntityInWorld(ItemDROP);
            	}
            }
    		itemstack.damageItem(1, entitylivingbase);
                return true;
            }
}


@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.WOOL_CARD);
}
}