package evercraft.NEMESIS13cz.Items.Powders;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Utils.TileEntityAcceptable;
import evercraft.NEMESIS13cz.Utils.TileEntityGenerator;



public class ItemNickelPowder extends Item {
public ItemNickelPowder() {
setCreativeTab(ECTabs.tabECWGMaterials);
}


@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.NICKEL_POWDER);
}
}