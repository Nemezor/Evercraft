package evercraft.NEMESIS13cz.Armor.Chestplate;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;

public class  ItemCopperChestplate extends ItemArmor {

	public ItemCopperChestplate(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
	}
	
    public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
    {
        par3.add("Durability: " + (this.getMaxDamage() - this.getDamage(par1)));
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.COPPER_CHESTPLATE);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return ModInformation.ARMORTEXTUREPATH + "/" + ModInformation.MODEL_COPPER_BOOTS_HELMET_CHESTPLATE;
	}
}