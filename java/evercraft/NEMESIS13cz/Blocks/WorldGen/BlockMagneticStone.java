package evercraft.NEMESIS13cz.Blocks.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class BlockMagneticStone extends Block {



public BlockMagneticStone() {
super(Material.iron);
setCreativeTab(ECTabs.tabECWGMaterials); //place in creative tabs
}
public Item getItemDropped(int par1, Random par2Random, int par3) {
return Evercraft_Items.magneticlump;
}
public int quantityDropped(Random par1Random)
{
    return 2;
}

public int quantityDroppedWithBonus(int par1, Random par2Random)
{
    if (par1 > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, par2Random, par1))
    {
        int j = par2Random.nextInt(par1 + 2) - 1;

        if (j < 0)
        {
            j = 0;
        }

        return this.quantityDropped(par2Random) * (j + 1);
    }
    else
    {
        return this.quantityDropped(par2Random);
    }
}

public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
{
    super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
}

public int getExpDrop(World par1World, int par5, int par7)
{
    if (this.getItemDropped(par5, par1World.rand, par7) != Item.getItemFromBlock(this))
    {
        int j1 = 0;
        
        j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 5, 10);
        return j1;
    }

    return 0;
}

public int damageDropped(int par1)
{
    return 0;
}



@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.MAGNETITE);
}
}