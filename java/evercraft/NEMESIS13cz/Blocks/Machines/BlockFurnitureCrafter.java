package evercraft.NEMESIS13cz.Blocks.Machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class BlockFurnitureCrafter extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconFront;

public BlockFurnitureCrafter()
{
         super(Material.wood);
         this.setCreativeTab(ECTabs.tabECMisc);
}


@SideOnly(Side.CLIENT)

/**
 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
 */
public IIcon getIcon(int par1, int par2)
{
    return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? Blocks.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 3 && par1 != 4 && par1 != 5 ? this.blockIcon : this.workbenchIconFront));
}

@SideOnly(Side.CLIENT)

/**
 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
 * is the only chance you get to register icons.
 */
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.workbenchIconTop = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.FURNITURECRAFTER_TOP);
    this.workbenchIconFront = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.FURNITURECRAFTER_FRONT);
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){

		if (player.isSneaking()){
		return false;
    }
	player.openGui(Evercraft.getEvercraft(), 11, world, x, y, z);
	
	return true;
}
}