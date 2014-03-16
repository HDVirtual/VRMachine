package RM;

import java.util.ArrayList;

public class RealMemory {
	
	ArrayList<String> memory = new ArrayList<String>();

	public RealMemory() {
		for (int i = 0; i < 16*16*16; i++) {
					memory.add(i, "_____");
    	}
    }
	
	public ArrayList<String> getBlock(int block) {
		ArrayList<String> blokas = new ArrayList<String>();
		for (int i = block*16-16; i < block*16; i++) {
			blokas.add(memory.get(i));
		}
    	return blokas;
    }
	
	public String getWord(int block, int index){
    	ArrayList<String> list = getBlock(block);
    	String Word = list.get(index);
    	return Word;
    }
}
