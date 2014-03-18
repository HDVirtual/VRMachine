package RM;

import java.util.ArrayList;

public class CommonMemory {
	
	ArrayList<String> memory = new ArrayList<String>();
	
	public CommonMemory() {
		for (int i = 0; i < 16; i++) {
					memory.add(i, "_____");
    	}
    }
	
	public String getWord(int index) {
    	String Word = memory.get(index);
    	return Word;
    }
	
	public String getWord(String adress) {
		int cell = getAdress(adress);
    	return memory.get(cell);
    }
	
	private int getAdress(String adress) {
		String result = adress.substring(3, 4);
		int cell = Integer.parseInt(result, 16);
		return cell;
    }
	
	public void set(String adress, String value) {
		memory.set(getAdress(adress),value);
	}
	
	public void set(int index, String value) {
		memory.set(index,value);
	}
}
