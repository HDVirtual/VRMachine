package RM;

import kontroleris.Main;
import RM.RM;


/**
 * Puslapi� lentel�
 * @author Aurimas
 *
 */
public class PageTable {
	int PageTableNumber;
	
	public PageTable() {
		this.PageTableNumber = RM.PTR.getPageTable();
		for(int i=0;i<Main.blokoDydis;i++) {
			RM.memory.set(this.PageTableNumber,""+3+i);
		}
		RM.memory.set(this.PageTableNumber, 7, ""+0);
	}
	public int getRealBlockNumber(int VirtualBlock) {
		String RBN = RM.memory.getWord(RM.PTR.getPageTable(), VirtualBlock);
		return Integer.parseInt(RBN);
	}
}
