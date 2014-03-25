package RM;

import java.util.ArrayList;

public class VA {

	int size;
	public VA(int size) {
		this.size = size;
	}

	public void set(int xx, String value) {
		int block = RM.PageTable.getRealBlockNumber(extractBlock(xx));
		int index = extractIndex(xx);
		RM.memory.set(block, index, value);
	}

	public String get(int xx) {
		int block = RM.PageTable.getRealBlockNumber(extractBlock(xx));
		int index = extractIndex(xx);
		return RM.memory.getWord(block, index);
	}
	
	public ArrayList<String> getBlock(int block) {
		int blokas = RM.PageTable.getRealBlockNumber(block);
		return getBlock(blokas);
	}
	
	public int extractBlock(int xx) {
		String hex = Integer.toHexString(xx);
		String block = hex.substring(0, 1);
		return Integer.parseInt(block, 16);
	}
	
	public int extractIndex(int xx) {
		String hex = Integer.toHexString(xx);
		String index = hex.substring(1, 2);
		return Integer.parseInt(index, 16);
	}

}