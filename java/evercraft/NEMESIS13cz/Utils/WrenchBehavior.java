package evercraft.NEMESIS13cz.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

	public class WrenchBehavior
	{
	    private static final WrenchBehavior wrenchBase = new WrenchBehavior();

	    private Map wrenchables = new HashMap();
	    private ArrayList<Block> rotatables = new ArrayList<Block>();

	    public static WrenchBehavior wrenching()
	    {
	        return wrenchBase;
	    }
	    
	    /**
	     * Adding the wrenchables and rotatables.
	     */
	    
	    private WrenchBehavior() {
			this.addWrenchable(Evercraft_Blocks.blockadvancedcrusherOff, Evercraft_Blocks.blockadvancedcrusherOff);
			this.addWrenchable(Evercraft_Blocks.blockadvancedcrusherOn, Evercraft_Blocks.blockadvancedcrusherOff);
			this.addWrenchable(Evercraft_Blocks.blockcrusherOff, Evercraft_Blocks.blockcrusherOff);
			this.addWrenchable(Evercraft_Blocks.blockcrusherOn, Evercraft_Blocks.blockcrusherOff);
			this.addWrenchable(Evercraft_Blocks.blockindustrialfurnaceOff, Evercraft_Blocks.blockindustrialfurnaceOff);
			this.addWrenchable(Evercraft_Blocks.blockindustrialfurnaceOn, Evercraft_Blocks.blockindustrialfurnaceOff);
			this.addWrenchable(Evercraft_Blocks.blockhightemperaturefurnaceOff, Evercraft_Blocks.blockhightemperaturefurnaceOff);
			this.addWrenchable(Evercraft_Blocks.blockhightemperaturefurnaceOn, Evercraft_Blocks.blockhightemperaturefurnaceOff);
			this.addWrenchable(Evercraft_Blocks.blockelectrolyzerOff, Evercraft_Blocks.blockelectrolyzerOff);
			this.addWrenchable(Evercraft_Blocks.blockelectrolyzerOn, Evercraft_Blocks.blockelectrolyzerOff);
			this.addWrenchable(Evercraft_Blocks.blockadvancedelectrolyzerOff, Evercraft_Blocks.blockadvancedelectrolyzerOff);
			this.addWrenchable(Evercraft_Blocks.blockadvancedelectrolyzerOn, Evercraft_Blocks.blockadvancedelectrolyzerOff);
			this.addWrenchable(Evercraft_Blocks.blockrepulsivecrusherOff, Evercraft_Blocks.blockrepulsivecrusherOff);
			this.addWrenchable(Evercraft_Blocks.blockrepulsivecrusherOn, Evercraft_Blocks.blockrepulsivecrusherOff);
			this.addWrenchable(Evercraft_Blocks.blockplatemillOff, Evercraft_Blocks.blockplatemillOff);
			this.addWrenchable(Evercraft_Blocks.blockplatemillOn, Evercraft_Blocks.blockplatemillOff);
			this.addWrenchable(Evercraft_Blocks.blockparticlemergerOff, Evercraft_Blocks.blockparticlemergerOff);
			this.addWrenchable(Evercraft_Blocks.blockparticlemergerOn, Evercraft_Blocks.blockparticlemergerOff);
			this.addWrenchable(Evercraft_Blocks.blockcasing1, Evercraft_Blocks.blockcasing1);
			this.addWrenchable(Evercraft_Blocks.blockcasing2, Evercraft_Blocks.blockcasing2);
			this.addWrenchable(Evercraft_Blocks.blockcasing3, Evercraft_Blocks.blockcasing3);
			this.addWrenchable(Evercraft_Blocks.blockminingmachine, Evercraft_Blocks.blockminingmachine);
			this.addWrenchable(Evercraft_Blocks.blockstandardgeneratorOff, Evercraft_Blocks.blockstandardgeneratorOff);
			this.addWrenchable(Evercraft_Blocks.blockstandardgeneratorOn, Evercraft_Blocks.blockstandardgeneratorOff);
			this.addWrenchable(Evercraft_Blocks.blocksolargenerator, Evercraft_Blocks.blocksolargenerator);
			this.addWrenchable(Evercraft_Blocks.blockredstonitecable, Evercraft_Blocks.blockredstonitecable);
			this.addWrenchable(Evercraft_Blocks.blockheatgeneratorOff_Idle, Evercraft_Blocks.blockheatgeneratorOff_Idle);
			this.addWrenchable(Evercraft_Blocks.blockheatgeneratorOn_Idle, Evercraft_Blocks.blockheatgeneratorOff_Idle);
			this.addWrenchable(Evercraft_Blocks.blockheatgeneratorOn_Active, Evercraft_Blocks.blockheatgeneratorOff_Idle);
			this.addWrenchable(Evercraft_Blocks.blockcentrifugeOff, Evercraft_Blocks.blockcentrifugeOff);
			this.addWrenchable(Evercraft_Blocks.blockcentrifugeOn, Evercraft_Blocks.blockcentrifugeOff);
			this.addWrenchable(Evercraft_Blocks.blockhammeringmachineOff, Evercraft_Blocks.blockhammeringmachineOff);
			this.addWrenchable(Evercraft_Blocks.blockhammeringmachineOn, Evercraft_Blocks.blockhammeringmachineOff);
			this.addWrenchable(Evercraft_Blocks.blockalloyfurnaceOff, Evercraft_Blocks.blockalloyfurnaceOff);
			this.addWrenchable(Evercraft_Blocks.blockalloyfurnaceOn, Evercraft_Blocks.blockalloyfurnaceOff);
			this.addWrenchable(Evercraft_Blocks.blockcuttingmachineOff, Evercraft_Blocks.blockcuttingmachineOff);
			this.addWrenchable(Evercraft_Blocks.blockcuttingmachineOn, Evercraft_Blocks.blockcuttingmachineOff);
			this.addWrenchable(Evercraft_Blocks.blockCapStorage, Evercraft_Blocks.blockCapStorage);
			this.addWrenchable(Evercraft_Blocks.blockItemPipeExtraction1, Evercraft_Blocks.blockItemPipeExtraction1);
			this.addWrenchable(Evercraft_Blocks.blockItemPipeExtraction2, Evercraft_Blocks.blockItemPipeExtraction2);
			this.addWrenchable(Evercraft_Blocks.blockItemPipeNormal_1, Evercraft_Blocks.blockItemPipeNormal_1);
			this.addWrenchable(Evercraft_Blocks.blockItemPipeNormal_2, Evercraft_Blocks.blockItemPipeNormal_2);
			this.addWrenchable(Evercraft_Blocks.blockItemPipeCrossing, Evercraft_Blocks.blockItemPipeCrossing);
			this.addWrenchable(Evercraft_Blocks.blockorefactoryOff, Evercraft_Blocks.blockorefactoryOff);
			this.addWrenchable(Evercraft_Blocks.blockorefactoryOn, Evercraft_Blocks.blockorefactoryOff);
			this.addWrenchable(Evercraft_Blocks.blockEnricherOff, Evercraft_Blocks.blockEnricherOff);
			this.addWrenchable(Evercraft_Blocks.blockEnricherOn, Evercraft_Blocks.blockEnricherOff);
			
			this.addRotatable(Evercraft_Blocks.blockCapStorage);
	    }
	    
	    public void addWrenchable(Block stack, Block res) {
	        this.wrenchables.put(stack, res);
	    }
	    
	    public void addRotatable(Block stack) {
	    	this.rotatables.add(stack);
	    }
	    
	    public Block getWrenchingResult(Block p_151395_1_)
	    {
	        Iterator iterator = this.wrenchables.entrySet().iterator();
	        Entry entry;

	        do
	        {
	            if (!iterator.hasNext())
	            {
	                return null;
	            }

	            entry = (Entry)iterator.next();
	        }
	        while (!this.func_151397_a(p_151395_1_, (Block)entry.getKey()));

	        return (Block)entry.getValue();
	    }
	    
	    private boolean func_151397_a(Block p_151397_1_, Block p_151397_2_)
	    {
	        return p_151397_1_ == p_151397_2_;
	    }
	    
	    public boolean isRotatable(Block stack) {
	    	return this.rotatables.contains(stack);
	    }

	    public Map getWrenchingList()
	    {
	        return this.wrenchables;
	    }
	
	/**
	 * Checks if the clicked block is rotateable.
	 * 
	 * @param wrenched
	 * @param metadata
	 * @return is the block rotateable
	 */
	
	public static boolean rotateables(Block wrenched) {
		return WrenchBehavior.wrenching().isRotatable(wrenched);
	}
	
	/**
	 * Checks if the wrenched block is wrenchable
	 * Directly called from the wrench.
	 * 
	 * @param wrenched
	 * @param metadata
	 * @return isInsertedBlockWrenchable
	 */
	
	public static boolean isWrenchable(Block wrenched) {
		if (WrenchBehavior.wrenching().getWrenchingResult(wrenched) != null) return true;
		
		return false;
	}
	
	/**
	 * Gets the block drop and calls dropMachine.
	 * Directly called from the wrench.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param wrenched
	 * @param metadata
	 */
	
	public static void wrenchMachine(World world, int x, int y, int z, Block wrenched) {
		dropMachine(world, x, y, z, WrenchBehavior.wrenching().getWrenchingResult(wrenched));
	}
	
	/**
	 * This does the actual work of removing and dropping the block thats being wrenched.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param dropped
	 */
	
	private static void dropMachine(World world, int x, int y, int z, Block dropped) {
    	world.setBlock(x, y, z, Blocks.air);
		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(dropped, 1, 0)));
	}
	
	/**
	 * Sets the metadata relative to the clicked side.
	 * Directly called from the wrench.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param side
	 */
	
	public static void rotateMachine(World world, int x, int y, int z, int side) {
		world.setBlockMetadataWithNotify(x, y, z, side, 2);
	}
}
