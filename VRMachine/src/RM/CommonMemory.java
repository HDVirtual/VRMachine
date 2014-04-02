package RM;

/*
 * @author Haroldas Baltrûnas
 * @author Deividas Frolovas
 */

import kontroleris.Main;

public class CommonMemory {

	private boolean[] CSemafor;

	public CommonMemory() {
		CSemafor = new boolean[Main.blokoDydis];

		for (int i = 0; i < Main.blokoDydis - 1; i++) {
			CSemafor[i] = false;
		}
	}

	public void activateCSemafor(int value, int cell) {
		if (value == 1)
			CSemafor[cell] = true;
		else if (value == 0)
			CSemafor[cell] = false;
	}

	public boolean usedCSemafor(int cell) {
		if (CSemafor[cell])
			return true;
		else
			return false;

	}
}
