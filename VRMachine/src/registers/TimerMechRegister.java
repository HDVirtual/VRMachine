package registers;
/*
 * @author Haroldas Baltrûnas
 * @author Deividas Frolovas
 */
public class TimerMechRegister {
	private int TI;
	public TimerMechRegister(int TI) {
		this.TI = TI;
	}

	public int get() {
		return this.TI;
	}

	public void set() {
			this.TI = this.TI - 1;
	}
	
	public void cleanTIMER(){
		this.TI = 0;
	}

	public void update() {
		this.TI = 10;
	}
}
