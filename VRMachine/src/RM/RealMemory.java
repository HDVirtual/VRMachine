package RM;

import java.util.ArrayList;

public class RealMemory {
	
	ArrayList<String> memory = new ArrayList<String>();

	public RealMemory() {
		for (int i = 0; i < 16*16*16; i++) {
					memory.add(i, "_____");
    	}
    }
}
