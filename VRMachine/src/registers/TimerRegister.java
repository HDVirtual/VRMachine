package registers;
/*
 * @author Haroldas Baltr�nas
 * @author Deividas Frolovas
 */
public class TimerRegister {

	private int T;
	public TimerRegister(int T) {
		this.T = T;
	}

	public int get() {
		return this.T;
	}

	public void set(int T) {
		this.T = T;
	}
}
