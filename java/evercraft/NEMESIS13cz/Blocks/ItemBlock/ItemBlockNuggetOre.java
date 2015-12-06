package evercraft.NEMESIS13cz.Blocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockNuggetOre extends ItemBlock
{
       public ItemBlockNuggetOre(Block par1)
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
			                 name = "gold";
			                 break;
			        }
			          case 1:
			          {
			                 name = "copper";
			                 break;
			          }
			          case 2:
			          {
			                 name = "iron";
			                 break;
			          }
			          case 3:
			          {
			                 name = "lead";
			                 break;
			          }
			          case 4:
			          {
			                 name = "zinc";
			                 break;
			          }
			          case 5:
			          {
			                 name = "tin";
			                 break;
			          }
			          case 6:
			          {
			                 name = "silver";
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