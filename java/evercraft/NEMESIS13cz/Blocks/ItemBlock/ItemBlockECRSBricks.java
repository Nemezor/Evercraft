package evercraft.NEMESIS13cz.Blocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockECRSBricks extends ItemBlock
{
       public ItemBlockECRSBricks(Block par1)
       {
             super(par1);
             setHasSubtypes(true);
       }
      
       public String getUnlocalizedName(ItemStack itemstack)
       {
             String name = "";
             switch(itemstack.getItemDamage())
             {
                    case 0:
                    {
                           name = "normal";
                           break;
                    }
                    case 1:
                    {
                           name = "circle";
                           break;
                    }
                    case 2:
                    {
                           name = "smooth";
                           break;
                    }
                    case 3:
                    {
                           name = "smoothCircle";
                           break;
                    }
                    
                    default: name = "broken";
             }
             return getUnlocalizedName() + "." + name;
       }
      
       public int getMetadata(int par1)
       {
           return par1;
       }
}