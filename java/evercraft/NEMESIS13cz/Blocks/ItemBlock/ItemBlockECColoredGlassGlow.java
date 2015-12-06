package evercraft.NEMESIS13cz.Blocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockECColoredGlassGlow extends ItemBlock
{
       public ItemBlockECColoredGlassGlow(Block par1)
       {
             super(par1);
             setHasSubtypes(true);
       }
      
       public String getUnlocalizedName(ItemStack itemstack)
       {
             String name = "" + "glow";
             switch(itemstack.getItemDamage())
             {
		        case 15:
		        {
		                 name = "black";
		                 break;
		        }
		          case 14:
		          {
		                 name = "red";
		                 break;
		          }
		          case 13:
		          {
		                 name = "green";
		                 break;
		          }
		          case 12:
		          {
		                 name = "brown";
		                 break;
		          }
		          case 11:
		          {
		                 name = "blue";
		                 break;
		          }
		          case 10:
		          {
		                 name = "purple";
		                 break;
		          }
		          case 9:
		          {
		                 name = "cyan";
		                 break;
		          }
		          case 8:
		          {
		                 name = "light_gray";
		                 break;
		          }
		          case 7:
		          {
		                 name = "gray";
		                 break;
		          }
		          case 6:
		          {
		                 name = "pink";
		                 break;
		          }
		          case 5:
		          {
		                 name = "lime";
		                 break;
		          }
		          case 4:
		          {
		                 name = "yellow";
		                 break;
		          }
		          case 3:
		          {
		                 name = "light_blue";
		                 break;
		          }
		          case 2:
		          {
		                 name = "magenta";
		                 break;
		          }
		          case 1:
		          {
		                 name = "orange";
		                 break;
		          }
		          case 0:
		          {
		                 name = "white";
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