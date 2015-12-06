package evercraft.NEMESIS13cz.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPowerNetwork extends BlockContainer {
	
	protected static boolean killNetwork = false;
	
	protected BlockPowerNetwork(Material m) {
		super(m);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return null;
	}

	@Override
    public void breakBlock(World world, int x, int y, int z, Block block, int par6) {
		super.breakBlock(world, x, y, z, block, par6);
	}
}
