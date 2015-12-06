package evercraft.NEMESIS13cz.Blocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockEC2Bricks extends ItemBlock
{
       public ItemBlockEC2Bricks(Block par1)
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
			                 name = "redstone";
			                 break;
			        }
			          case 1:
			          {
			                 name = "redstoneCircle";
			                 break;
			          }
			          case 2:
			          {
			                 name = "obsidian";
			                 break;
			          }
			          case 3:
			          {
			                 name = "obsidianCircle";
			                 break;
			          }
			          case 4:
			          {
			                 name = "nether";
			                 break;
			          }
			          case 5:
			          {
			                 name = "netherCircle";
			                 break;
			          }
			          case 6:
			          {
			                 name = "iron";
			                 break;
			          }
			          case 7:
			          {
			                 name = "ironCircle";
			                 break;
			          }
			          case 8:
			          {
			                 name = "gold";
			                 break;
			          }
			          case 9:
			          {
			                 name = "goldCircle";
			                 break;
			          }
			          case 10:
			          {
			                 name = "diamond";
			                 break;
			          }
			          case 11:
			          {
			                 name = "diamondCircle";
			                 break;
			          }
			          case 12:
			          {
			                 name = "emerald";
			                 break;
			          }
			          case 13:
			          {
			                 name = "emeraldCircle";
			                 break;
			          }
			          case 14:
			          {
			                 name = "lapis";
			                 break;
			          }
			          case 15:
			          {
			                 name = "lapisCircle";
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