package evercraft.NEMESIS13cz.Blocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockPlatedCarpet extends ItemBlock
{
       public ItemBlockPlatedCarpet(Block par1)
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
			                 name = "iron";
			                 break;
			        }
			          case 1:
			          {
			                 name = "titanium";
			                 break;
			          }
			          case 2:
			          {
			                 name = "tin";
			                 break;
			          }
			          case 3:
			          {
			                 name = "steel";
			                 break;
			          }
			          case 4:
			          {
			                 name = "silver";
			                 break;
			          }
			          case 5:
			          {
			                 name = "gold";
			                 break;
			          }
			          case 6:
			          {
			                 name = "diamond";
			                 break;
			          }
			          case 7:
			          {
			                 name = "emerald";
			                 break;
			          }
			          case 8:
			          {
			                 name = "copper";
			                 break;
			          }
			          case 9:
			          {
			                 name = "bronze";
			                 break;
			          }
			          case 10:
			          {
			                 name = "aluminium";
			                 break;
			          }
			          case 11:
			          {
			                 name = "quartz";
			                 break;
			          }
			          case 12:
			          {
			                 name = "zinc";
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