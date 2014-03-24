package RM;



import java.util.ArrayList;

import kontroleris.Main;


/**
 * Vartotojo atmintis
 * 
 * @author Aurimas
 * 
 */
public class VA {

	int memory;
	public VA(int memory) {
		this.memory = memory;
	}
	/**
	 * Norimu adresu gauname elementà ið vartotoji atminties
	 * 
	 * @param a
	 *            Atminties adresas
	 * @return
	 */
	public void set(int index, String element) {
		int[] digit = getInt(index);
		int AA = RM.PageTable.getRealBlockNumber(digit[0]);
		RM.memory.set(AA, digit[1], element);
	}

	public String get(int a) {
		int[] digit = getInt(a);
		int AA = RM.PageTable.getRealBlockNumber(digit[0]);
		return RM.memory.getWord(AA, digit[1]);
	}
	public int getAA(int a) {
		int[] digit = getInt(a);
		int AA = RM.PageTable.getRealBlockNumber(digit[0])*Main.blokoDydis+digit[1];
		return AA;
	}

	public ArrayList<String> getList() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < Main.RMBlokuSkaicius; i++) {
			for (int n = 0; n < Main.blokoDydis; n++) {
				list.add(RM.memory.getWord(i, n));
			}
		}
		return list;
	}

	public int getAllMemory() {
		return this.memory;
	}
	private int[] getInt(int xx) {
		String string = Integer.toString(xx);
		int[] digits = new int[string.length()+1];
		if (string.length() == 1) {
			digits[1] = Integer.parseInt(string);
			digits[0] = 0;
		} else {
			for (int i = 0; i < string.length(); ++i) {
				digits[i] = Integer.parseInt(string.substring(i, i + 1));
			}
		}
		return digits;
    }
}