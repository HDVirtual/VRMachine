package RM;

import java.util.ArrayList;

public class RealMemory {
	
	ArrayList<String> memory = new ArrayList<String>();

	public RealMemory() {
		for (int i = 0; i < 16*16*16-16; i++) {
					memory.add(i, "_____");
    	}
    }
	
	public ArrayList<String> getBlock(int block) {
		ArrayList<String> blokas = new ArrayList<String>();
		for (int i = (block+1)*16-16; i < (block+1)*16; i++) {
			blokas.add(memory.get(i));
		}
    	return blokas;
    }
	
	public String getWord(int block, int index){
    	ArrayList<String> list = getBlock(block);
    	String Word = list.get(index);
    	return Word;
    }
	
	public String getWord(String adress) {
		int cell = getAdress(adress);
    	return memory.get(cell);
    }
	
	private int getAdress(String adress) {
		String result = adress.substring(2, 4);
		int cell = Integer.parseInt(result, 16);
		return cell;
    }
	
	public void set(String adress, String value) {
		memory.set(getAdress(adress),value);
	}
}
