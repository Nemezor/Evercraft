package evercraft.NEMESIS13cz.Tools.Multi;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Tools.Base.ToolMulti;

public class ItemBronzeMultiTool extends ToolMulti
{

    private int weaponDamage;
	
    public ItemBronzeMultiTool(Item.ToolMaterial par2EnumToolMaterial)
    {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
    }

    public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
    {
        par3.add("Uses: " + (this.getMaxDamage() - this.getDamage(par1)));
        par3.add("Mining Speed: 3.0");
        par3.add("Mining Level: Redstone");
        par3.add("Damage: 2 hearts");
    }



@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister){
	    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.BRONZE_MULTI_TOOL);
	}
}
