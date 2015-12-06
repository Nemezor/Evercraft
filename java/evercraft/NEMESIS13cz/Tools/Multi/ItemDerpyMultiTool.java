package evercraft.NEMESIS13cz.Tools.Multi;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Tools.Base.ToolMulti;

public class ItemDerpyMultiTool extends ToolMulti
{

    private int weaponDamage;
	
    public ItemDerpyMultiTool(Item.ToolMaterial par2EnumToolMaterial)
    {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
    }

    public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
    {
        par3.add("Uses: " + (this.getMaxDamage() - this.getDamage(par1)));
        par3.add("Mining Speed: 12.0");
        par3.add("Mining Level: Obsidian");
        par3.add("Damage: 12 hearts");
        if (par2.getGameProfile().getId().toString().equals("0b757efe-bee3-4d3c-8c2f-73f19717da61") || par2.getGameProfile().getId().toString().equals("e452e012-2c82-456d-853b-3ac8e6b581f5")) {
            par3.add("Did this " + EnumChatFormatting.GREEN + "Impressed You" + EnumChatFormatting.GRAY + "?");
        }
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
public void registerIcons(IIconRegister par1IconRegister){
	    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.DERPY_MULTI_TOOL);
	}
}
