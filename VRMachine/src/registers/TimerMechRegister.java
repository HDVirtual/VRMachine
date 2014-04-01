package registers;
/*
 * @author Haroldas Baltrûnas
 * @author Deividas Frolovas
 */
public class TimerMechRegister {
	private int TIMER;
	public TimerMechRegister(int TI) {
		this.TIMER = TI;
	}

	public int get() {
		return this.TIMER;
	}

	public void set() {
			this.TI = this.TI - 1;
	}
	
	public void cleanTIMER(){
		this.TIMER = 0;
	}

	public void reset() {
		this.TIMER = 10;
	}
}
