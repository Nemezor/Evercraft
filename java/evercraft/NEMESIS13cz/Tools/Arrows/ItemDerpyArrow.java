package evercraft.NEMESIS13cz.Tools.Arrows;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemDerpyArrow extends Item {
public ItemDerpyArrow() {
setCreativeTab(ECTabs.tabECTools); //Tells the game what creative mode tab it goes in
}

@SideOnly(Side.CLIENT)
public boolean hasEffect(ItemStack par1ItemStack)
{
    return true;
}

public EnumRarity getRarity(ItemStack par1ItemStack)
{
    return EnumRarity.rare;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.DERPY_ARROW);
}
}