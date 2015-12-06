package evercraft.NEMESIS13cz.Items.Misc;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class ItemGlassTube extends Item implements IFluidContainerItem {

  protected final int capacity;
  
  public ItemGlassTube(int capacity1) {
    super();
    this.capacity = capacity1;
    this.setCreativeTab(ECTabs.tabECMetaM);
  }
  
  @SideOnly(Side.CLIENT)
  public static IIcon empty;
  @SideOnly(Side.CLIENT)
  public static IIcon fluid;
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister par1IconRegister)
  {
      this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.GLASSFLUIDTUBE);
      this.empty = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.GLASSFLUIDTUBE_EMPTY);
      this.fluid = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.GLASSFLUIDTUBE_FLUID);
      
  }

  @SideOnly(Side.CLIENT)
  public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList)
  {
    itemList.add(new ItemStack(Evercraft_Items.glassTube).copy());
    for (Iterator it = FluidRegistry.getRegisteredFluidIDs().values().iterator(); it.hasNext();)
    {
      int fluidId = ((Integer)it.next()).intValue();
      ItemStack stack = new ItemStack(Evercraft_Items.glassTube).copy();
      fill(stack, new FluidStack(fluidId, Integer.MAX_VALUE), true);
      itemList.add(stack);
    }
  }
  
  public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b)
  {
    FluidStack fs = getFluid(itemStack);
    if (fs != null) {
      info.add(EnumChatFormatting.DARK_GRAY + ">> " + EnumChatFormatting.GOLD + StatCollector.translateToLocal(FluidRegistry.getFluidName(fs)) + EnumChatFormatting.DARK_GRAY + " <> " + EnumChatFormatting.LIGHT_PURPLE + fs.amount + " mB" + EnumChatFormatting.DARK_GRAY + " <<");
    }else{
      info.add(EnumChatFormatting.DARK_GRAY + ">> " + EnumChatFormatting.GOLD + "empty" + EnumChatFormatting.DARK_GRAY + " <<");
    }
  }
  
  public FluidStack getFluid(ItemStack stack)
  {
    NBTTagCompound nbtTagCompound = stack.getTagCompound();
    if (nbtTagCompound == null)
    {
    	nbtTagCompound = new NBTTagCompound();
      
      stack.setTagCompound(nbtTagCompound);
    }
    NBTTagCompound fluidTag = nbtTagCompound.getCompoundTag("Fluid");
    
    return FluidStack.loadFluidStackFromNBT(fluidTag);
  }
  
  public boolean isEmpty(ItemStack stack)
  {
    return getFluid(stack) == null;
  }
  
  public int getCapacity(ItemStack container)
  {
    return this.capacity;
  }
  
  public int fill(ItemStack stack, FluidStack resource, boolean doFill)
  {
    if (stack.stackSize != 1) {
      return 0;
    }
    if (resource == null) {
      return 0;
    }
    NBTTagCompound nbtTagCompound = stack.getTagCompound();
    if (nbtTagCompound == null)
    {
    	nbtTagCompound = new NBTTagCompound();
      
      stack.setTagCompound(nbtTagCompound);
    }
    NBTTagCompound fluidTag = nbtTagCompound.getCompoundTag("Fluid");
    FluidStack fs = FluidStack.loadFluidStackFromNBT(fluidTag);
    if (fs == null) {
      fs = new FluidStack(resource, 0);
    }
    if (!fs.isFluidEqual(resource)) {
      return 0;
    }
    int amount = Math.min(this.capacity - fs.amount, resource.amount);
    if ((doFill) && (amount > 0))
    {
      fs.amount += amount;
      fs.writeToNBT(fluidTag);
      nbtTagCompound.setTag("Fluid", fluidTag);
    }
    return amount;
  }
  
  public FluidStack drain(ItemStack stack, int maxDrain, boolean doDrain)
  {
    if (stack.stackSize != 1) {
      return null;
    }
    NBTTagCompound nbtTagCompound = stack.getTagCompound();
    if (nbtTagCompound == null)
    {
    	nbtTagCompound = new NBTTagCompound();
      
      stack.setTagCompound(nbtTagCompound);
    }
    NBTTagCompound fluidTag = nbtTagCompound.getCompoundTag("Fluid");
    FluidStack fs = FluidStack.loadFluidStackFromNBT(fluidTag);
    if (fs == null) {
      return null;
    }
    maxDrain = Math.min(fs.amount, maxDrain);
    if (doDrain)
    {
      fs.amount -= maxDrain;
      if (fs.amount <= 0)
      {
        nbtTagCompound.removeTag("Fluid");
      }
      else
      {
        fs.writeToNBT(fluidTag);
        nbtTagCompound.setTag("Fluid", fluidTag);
      }
    }
    return new FluidStack(fs, maxDrain);
  }
}
