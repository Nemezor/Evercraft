package evercraft.NEMESIS13cz.Renderers.Item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

import evercraft.NEMESIS13cz.Items.Misc.ItemGlassTube;

public class ItemGlassTubeRenderer
  implements IItemRenderer
{
  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
  {
    return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)) || (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.ENTITY));
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
  {
    return type == IItemRenderer.ItemRenderType.ENTITY;
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
  {
    ItemGlassTube tube = (ItemGlassTube)item.getItem();
    IIcon icon = item.getIconIndex();
    IIcon icon_empty = tube.empty;
    
    GL11.glEnable(3042);
    GL11.glEnable(3008);
    if (type.equals(IItemRenderer.ItemRenderType.ENTITY))
    {
      GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
      GL11.glTranslated(-0.5D, 0.0D, 0.0D);
    }
    FluidStack fs = tube.getFluid(item);
    if (fs != null)
    {
      IIcon windowIcon = tube.fluid;
      IIcon fluidicon = fs.getFluid().getIcon(fs);
      int fluidColor = fs.getFluid().getColor(fs);
      


      Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
      
      GL11.glBlendFunc(0, 1);
      if (type.equals(IItemRenderer.ItemRenderType.INVENTORY))
      {
        renderIcon(windowIcon, 0.0D, 0.0D, 16.0D, 16.0D, 0.0D, 0.0F, 0.0F, -1.0F);
      }
      else
      {
        renderIcon(windowIcon, 1.0D, 1.0D, 0.0D, 0.0D, -0.001D, 0.0F, 0.0F, 1.0F);
        renderIcon(windowIcon, 1.0D, 1.0D, 0.0D, 0.0D, -0.0615D, 0.0F, 0.0F, -1.0F);
      }
      Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
      
      GL11.glBlendFunc(770, 771);
      GL11.glDepthFunc(514);
      GL11.glColor3ub((byte)(fluidColor >> 16), (byte)(fluidColor >> 8), (byte)fluidColor);
      if (type.equals(IItemRenderer.ItemRenderType.INVENTORY))
      {
        renderIcon(fluidicon, 0.0D, 0.0D, 16.0D, 16.0D, 0.0D, 0.0F, 0.0F, -1.0F);
      }
      else
      {
        renderIcon(fluidicon, 0.0D, 0.0D, 1.0D, 1.0D, -0.001D, 0.0F, 0.0F, 1.0F);
        renderIcon(fluidicon, 0.0D, 0.0D, 1.0D, 1.0D, -0.0615D, 0.0F, 0.0F, -1.0F);
      }
      GL11.glColor3ub((byte)-1, (byte)-1, (byte)-1);
      GL11.glDepthFunc(515);

      Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
      
      GL11.glBlendFunc(770, 771);
      if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
        renderIcon(icon, 0.0D, 0.0D, 16.0D, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
      } else {
        ItemRenderer.renderItemIn2D(Tessellator.instance, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
      }
    }else{
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
        
        GL11.glBlendFunc(770, 771);
        if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
          renderIcon(icon_empty, 0.0D, 0.0D, 16.0D, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
        } else {
          ItemRenderer.renderItemIn2D(Tessellator.instance, icon_empty.getMaxU(), icon_empty.getMinV(), icon_empty.getMinU(), icon_empty.getMaxV(), icon_empty.getIconWidth(), icon_empty.getIconHeight(), 0.0625F);
        }
    }
    GL11.glDisable(3008);
    GL11.glDisable(3042);
  }
  
  public static void renderIcon(IIcon icon, double xStart, double yStart, double xEnd, double yEnd, double z, float nx, float ny, float nz)
  {
    if (icon == null) {
      icon = getMissingIcon(TextureMap.locationItemsTexture);
    }
    Tessellator tessellator = Tessellator.instance;
    
    tessellator.startDrawingQuads();
    tessellator.setNormal(nx, ny, nz);
    if (nz > 0.0F)
    {
      tessellator.addVertexWithUV(xStart, yStart, z, icon.getMinU(), icon.getMinV());
      tessellator.addVertexWithUV(xEnd, yStart, z, icon.getMaxU(), icon.getMinV());
      tessellator.addVertexWithUV(xEnd, yEnd, z, icon.getMaxU(), icon.getMaxV());
      tessellator.addVertexWithUV(xStart, yEnd, z, icon.getMinU(), icon.getMaxV());
    }
    else
    {
      tessellator.addVertexWithUV(xStart, yEnd, z, icon.getMinU(), icon.getMaxV());
      tessellator.addVertexWithUV(xEnd, yEnd, z, icon.getMaxU(), icon.getMaxV());
      tessellator.addVertexWithUV(xEnd, yStart, z, icon.getMaxU(), icon.getMinV());
      tessellator.addVertexWithUV(xStart, yStart, z, icon.getMinU(), icon.getMinV());
    }
    tessellator.draw();
  }

  public static IIcon getMissingIcon(ResourceLocation textureSheet)
  {
    return ((TextureMap)Minecraft.getMinecraft().getTextureManager().getTexture(textureSheet)).getAtlasSprite("missingno");
  }
}
