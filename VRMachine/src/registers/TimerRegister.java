package registers;
/*
 * @author Haroldas Baltr�nas
 * @author Deividas Frolovas
 */
public class TimerRegister {

	private int TI;
	public TimerRegister(int T) {
		this.TI = T;
	}

	public int get() {
		return this.TI;
	}

	public void set(int T) {
		this.TI = T;
	}
}
