package RM;

import java.util.ArrayList;

import kontroleris.Main;

public class RealMemory {
	
	ArrayList<String> memory = new ArrayList<String>();

	public RealMemory(int blokai) {
		for (int i = 0; i < blokai*Main.blokoDydis; i++) {
					memory.add(i, "____");
    	}
    }
	
	public ArrayList<String> getBlock(int block) {
		ArrayList<String> blokas = new ArrayList<String>();
		for (int i = (block+1)*Main.blokoDydis-16; i < (block+1)*Main.blokoDydis; i++) {
			blokas.add(memory.get(i));
		}
    	return blokas;
    }
	
	public String getWord(int block, int index){
		int cell = block*Main.blokoDydis+index;
    	return memory.get(cell);
    }
	
	public String getWord(String adress) {
		int cell = getAdress(adress);
    	return memory.get(cell);
    }
	
	public String getWord(int adress) {
    	return memory.get(adress);
    }
	
	private int getAdress(String adress) {
		String result = adress.substring(2, 5);
		int cell = Integer.parseInt(result, 16);
		return cell;
    }
	
	public void set(String adress, String value) {
		memory.set(getAdress(adress),value);
	}
	
	public void set(int adress, String value) {
		memory.set(adress,value);
	}
	
	public void set(int block, int xx, String value) {
    	int cell = block*Main.blokoDydis+xx;
    	memory.set(cell,value);
    }
}
