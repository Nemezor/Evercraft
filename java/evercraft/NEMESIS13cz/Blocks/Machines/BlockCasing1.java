package evercraft.NEMESIS13cz.Blocks.Machines;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class BlockCasing1 extends Block {



public BlockCasing1(String texture) {
super(Material.iron);
setCreativeTab(ECTabs.tabECMachines);
}
public Item getItemDropped(int par1, Random par2Random, int par3) {
	return Item.getItemFromBlock(Blocks.iron_block);
	}
	public int quantityDropped(Random random) {
	return 1;
	}


@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.MACHINE_CASING_1);
}
}