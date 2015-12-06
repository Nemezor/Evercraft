package evercraft.NEMESIS13cz.Tools.Base;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemToolPowered extends Item
{
    private Set field_150914_c;
    protected float efficiencyOnProperMaterial = 1.0F;
    /** Damage versus entities. */
    private float damageVsEntity;
    /** The material this tool is made from. */
    protected Item.ToolMaterial toolMaterial;

    protected ItemToolPowered(float p_i45333_1_, Item.ToolMaterial p_i45333_2_, Set p_i45333_3_)
    {
        this.toolMaterial = p_i45333_2_;
        this.field_150914_c = p_i45333_3_;
        this.maxStackSize = 1;
        this.setMaxDamage(0);
        this.efficiencyOnProperMaterial = p_i45333_2_.getEfficiencyOnProperMaterial();
        this.damageVsEntity = p_i45333_1_ + p_i45333_2_.getDamageVsEntity();
        this.setCreativeTab(ECTabs.tabECTools);
        if (this instanceof ItemPickaxePowered)
        {
            toolClass = "pickaxe";
        }
        else if (this instanceof ItemAxePowered)
        {
            toolClass = "axe";
        }
        else if (this instanceof ItemSpadePowered)
        {
            toolClass = "shovel";
        }
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return (this.field_150914_c.contains(p_150893_2_) && p_150893_1_.stackTagCompound.getLong("charge") > 9) ? this.efficiencyOnProperMaterial : 1.0F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entitylivingbase1, EntityLivingBase entitylivingbase2)
    {
    	if (itemstack.stackTagCompound != null && itemstack.stackTagCompound.getLong("charge") > 10) {
        	int charge = (int)itemstack.stackTagCompound.getLong("charge");
        	charge -= 10;
        	itemstack.stackTagCompound.setLong("charge", (long)charge);
        return true;
    	}else{
    		itemstack.stackTagCompound = new NBTTagCompound();
    	return false;
    	}
    }

    public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase entitylivingbase)
    {
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D) {
        	if (itemstack.stackTagCompound != null && itemstack.stackTagCompound.getLong("charge") > 10) {
            	int charge = (int)itemstack.stackTagCompound.getLong("charge");
            	charge -= 10;
            	itemstack.stackTagCompound.setLong("charge", (long)charge);
            return true;
        	}else{
        		itemstack.stackTagCompound = new NBTTagCompound();
        	return false;
        	}
        }else{
        	return false;
        }
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public Item.ToolMaterial func_150913_i()
    {
        return this.toolMaterial;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }

    /*===================================== FORGE START =================================*/
    private String toolClass;
    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass)
    {
        int level = super.getHarvestLevel(stack, toolClass);
        if (level == -1 && toolClass != null && toolClass.equals(this.toolClass))
        {
            return this.toolMaterial.getHarvestLevel();
        }
        else
        {
            return level;
        }
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack)
    {
        return toolClass != null ? ImmutableSet.of(toolClass) : super.getToolClasses(stack);
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {
    	if (stack.stackTagCompound.getLong("charge") > 9) {
            if (ForgeHooks.isToolEffective(stack, block, meta))
            {
                return efficiencyOnProperMaterial;
            }
    	}
        return super.getDigSpeed(stack, block, meta);
    }
    /*===================================== FORGE END =================================*/
}