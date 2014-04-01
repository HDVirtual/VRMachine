package registers;
/*
 * @author Haroldas Baltrûnas
 * @author Deividas Frolovas
 */
public class CHST {
	private int[] reg = new int[4];
	
	public CHST() {
		this.reg[0] = 0;
		this.reg[1] = 0;
		this.reg[2] = 0;
		this.reg[3] = 0;
	}

	public int get(int numeris) {
		return this.reg[numeris];
	}

	public void cleanCHST(){
		this.reg[0] = 0;
		this.reg[1] = 0;
		this.reg[2] = 0;
		this.reg[3] = 0;
	}
	
	public void set(int reiksme, int numeris) {
		this.reg[numeris] = reiksme;
	}
}
