package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityConductanceCoil;

public class BlockConductanceCoil extends BlockContainer {

public BlockConductanceCoil() {
	super(Material.iron);
}

public boolean renderAsNormalBlock() {
	return false;
}

public boolean isOpaqueCube() {
	return false;
}

public int getRenderType() {
	return -1;
}

public Item getItemDropped(int par1, Random par2Random, int par3) {
	return Evercraft_Items.coil;
}

@SideOnly(Side.CLIENT)
public Item getItem(World par1World, int par2, int par3, int par4) {
	return Evercraft_Items.coil;
}

public int quantityDropped(Random random) {
return 1;
}

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ADV_CONDUCTANCE_COIL);
}

@Override
public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
	return new TileEntityConductanceCoil();
}
}