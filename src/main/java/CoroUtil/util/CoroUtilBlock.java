package CoroUtil.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class CoroUtilBlock {

	public static Block setUnlocalizedNameAndTexture(Block block, String nameTex) {
		block.setBlockName(nameTex);
		//block.setTextureName(nameTex);
    	return block;
    }
	
	public static boolean isAir(Block parBlock) {
		Material mat = parBlock.getMaterial();
		if (mat == Material.air) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isEqual(Block parBlock, Block parBlock2) {
		return parBlock == parBlock2;
	}
	
	public static boolean isEqualMaterial(Block parBlock, Material parMaterial) {
		return parBlock.getMaterial() == parMaterial;
	}
	
	public static Block getBlockByName(String name) {
		try {
			return (Block) Block.blockRegistry.getObject(name);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/*public static String getNameByItem(Item item) {
		return Block.blockRegistry.getNameForObject(item);
	}*/
	
	public static String getNameByBlock(Block item) {
		return Block.blockRegistry.getNameForObject(item);
	}
	
}
