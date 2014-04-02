package RM;
/*
 * @author Haroldas Baltrûnas
 * @author Deividas Frolovas
 */
import java.util.ArrayList;
import java.util.Collections;

import kontroleris.Main;
import RM.RM;

public class PageTable {  // galima padaryti pi=4 jei truksta tusciu bloku
	
	private static int adress;
	private static ArrayList<Integer> randomList = new ArrayList<Integer>(Main.RMBlokuSkaicius - 1);
	private static boolean commonCreated = false;
	
	public PageTable() {
		int element = 0;
		for (int i = 0; i < Main.RMBlokuSkaicius-1; i++) {
			if (emptyBlock(i)) {
				randomList.add(element, i);
				element += 1;
			}
		}
		createVM();
		for (int i = 0; i < Main.blokoDydis; i++){
			
		}
	}
	
	
	public static boolean createVM(){
		try{
			Collections.shuffle(randomList);
			setAdress(randomList.get(0));
			RM.PTR.setPageTable(PageTable.getAdress());
			randomList.remove(0);
			for (int i = 0; i < Main.blokoDydis; i++) {
				RM.memory.set(getAdress(), i, Integer.toHexString(randomList.get(0)));
				randomList.remove(0);
			}
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
		
	public int getRealBlockNumber(int VirtualBlock) {
		String number = RM.memory.getWord(RM.PTR.getPageTable(), VirtualBlock);
		int cell = Integer.parseInt(number, 16);
		return cell;
	}
	public boolean emptyBlock(int block){
		boolean x = true;
		for (int n = 0; n < Main.blokoDydis; n++) {
			if (RM.memory.getWord(block, n) != "____") {
				x = false;
			}
		}
		return x;
	}


	public static int getAdress() {
		return adress;
	}


	public static void setAdress(int adress) {
		PageTable.adress = adress;
	}
}
