package RM;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class ExternalMemory {
	
	static ArrayList<String> memory = new ArrayList<String>();

	public ExternalMemory() {
		for (int i = 0; i < 16*16; i++) {
					memory.add(i, "____");
    	}
    }
	
	public static ArrayList<String> getBlock(int block) {
		ArrayList<String> blokas = new ArrayList<String>();
		for (int i = (block+1)*16-16; i < (block+1)*16; i++) {
			blokas.add(memory.get(i));
		}
    	return blokas;
    }
	
	public static String getWord(int block, int index){
    	ArrayList<String> list = getBlock(block);
    	String Word = list.get(index);
    	return Word;
    }
	
	public String getWord(int adress) {
    	return memory.get(adress);
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
	
	public void set(int adress, String value) {
		memory.set(adress,value);
	}
	
	public void save() {
		try {
			FileWriter fstream = new FileWriter("HDD.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i = 0; i < 16; i++) {
				for (int n = 0; n < 16; n++) {
					out.write(getWord(i, n)+"\n");
				}
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
    }
	
	
}
