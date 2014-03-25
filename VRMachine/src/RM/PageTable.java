package RM;

import java.util.ArrayList;
import java.util.Collections;

import kontroleris.Main;
import RM.RM;

public class PageTable {  // galima padaryti pi=4 jei truksta tusciu bloku
	
	int adress;
	
	public PageTable() {
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		int x = 0;
		int element = 0;
		for (int i = 0; i < Main.RMBlokuSkaicius; i++) {
			for (int n = 0; i < Main.blokoDydis; i++) {
				if (RM.memory.getWord(i, n) != "____") {
					x = 1;
				}
			}
			if (x == 0) {
				randomList.add(element, i);
				element += 1;
			}
			x = 0;
		}
		Collections.shuffle(randomList);
		this.adress = randomList.get(0);
		randomList.remove(0);
		for (int i = 0; i < Main.blokoDydis; i++) {
			Collections.shuffle(randomList);
			RM.memory.set(this.adress, i, Integer.toHexString(randomList.get(0)));
			randomList.remove(0);
		}
	}
	
	public int getAdress() {
		return this.adress;
	}
	
	public int getRealBlockNumber(int VirtualBlock) {
		String number = RM.memory.getWord(RM.PTR.getPageTable(), VirtualBlock);
		int cell = Integer.parseInt(number, 16);
		return cell;
	}
}
