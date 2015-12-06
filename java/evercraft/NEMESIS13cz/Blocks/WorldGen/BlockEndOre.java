package evercraft.NEMESIS13cz.Blocks.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldBase;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class BlockEndOre extends Block {

public BlockEndOre(String texture) {
super(Material.rock);
setCreativeTab(ECTabs.tabECWGMaterials);
}


public Item getItemDropped(int par1, Random random, int par3) {
	Item item;
	int k = random.nextInt(13);
if (k == 0) {
	item = Evercraft_Items.redstonitedust;
}else
if (k == 1) {
	item = Evercraft_Items.diamonddust;
}else
if (k == 2) {
	item = Items.quartz;
}else
if (k == 3) {
	item = Items.egg;
}else
if (k == 4) {
	item = Evercraft_Items.irondust;
}else
if (k == 5) {
	item = Evercraft_Items.golddust;
}else
if (k == 6) {
	item = Evercraft_Items.emeralddust;
}else
if (k == 7) {
	item = Evercraft_Items.magneticlump;
}else
if (k == 8) {
	item = Items.redstone;
}else
if (k == 9) {
	item = Evercraft_Items.titaniumdust;
}else
if (k == 10) {
	item = Evercraft_Items.obsidiandust;
}else
if (k == 11) {
	item = Evercraft_Items.electrumdust;
}else
{ //if k == 12
	item = Evercraft_Items.sphenedust;
}
return item;

}

public boolean canEntityDestroy(World world, int x, int y, int z) {
	return false;
}



public int quantityDropped(Random random) {
return Evercraft_Config_WorldBase.enderoreDROP;
}



@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.END_ORE);
}
}