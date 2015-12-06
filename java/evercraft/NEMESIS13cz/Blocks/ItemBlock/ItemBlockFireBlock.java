package evercraft.NEMESIS13cz.Blocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;


public class ItemBlockFireBlock extends ItemBlock
{
       public ItemBlockFireBlock(Block par1) {
             super(Evercraft_Blocks.blockfireblock);
             setHasSubtypes(true);
       }
      
       public String getUnlocalizedName(ItemStack itemstack)
       {
             String name = "";
             switch(itemstack.getItemDamage())
             {
			        case 0:
			        {
			                 name = "smoke";
			                 break;
			        }
			          case 1:
			          {
			                 name = "flame";
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