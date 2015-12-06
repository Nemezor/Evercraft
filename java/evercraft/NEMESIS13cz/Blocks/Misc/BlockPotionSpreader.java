package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Items.Misc.ItemPotionMatrix;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityPotionSpreader;

public class BlockPotionSpreader extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon blockSide;
	
	public BlockPotionSpreader() {
		super(Material.rock);
		setCreativeTab(ECTabs.tabECMisc);
	}

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	if (world.getTileEntity(x, y, z) instanceof TileEntityPotionSpreader && player.getCurrentEquippedItem() != null) {
    		if (world.isRemote) {
    			return true;
    		}else{
    			TileEntityPotionSpreader tileentity = (TileEntityPotionSpreader)world.getTileEntity(x, y, z);
    			
    			if (player.getCurrentEquippedItem().getItem() == Evercraft_Items.potionmatrix && player.getCurrentEquippedItem().getItemDamage() > 0) {
        			tileentity.setPotionType(player.getCurrentEquippedItem().getItemDamage());
        			ItemPotionMatrix.damageItem(1, 4, player.getCurrentEquippedItem());
    			}
    			return true;
    		}
    	}else{
    		return false;
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + 1.1F;
            float f2 = (float)par4 + 0.5F;

            Minecraft.getMinecraft().effectRenderer.addEffect(new EntitySpellParticleFX(par1World, (double)(f), (double)(f1), (double)(f2), 0.0D, 0.0D, 0.0D));        
    }

    public TileEntity createNewTileEntity(World par1World, int par2) {
        return new TileEntityPotionSpreader();
    }

	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return par1 == 1 ? this.blockIcon : this.blockSide;
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.POTION_SPREADER_TOP);
        this.blockSide = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.POTION_SPREADER_SIDE);
    }
}
