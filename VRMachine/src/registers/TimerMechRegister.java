package registers;

public class TimerMechRegister {
	private int TI;
	public TimerMechRegister(int TI) {
		this.TI = TI;
	}

	public int get() {
		return this.TI;
	}

	public void set() {
		if (this.TI != 1) {
			this.TI = this.TI - 1;
		} else {
			this.TI = this.TI - 1;
			//RM.RM.T.set(1);
			RM.RM.MODE.set(1);
			update();
		}
	}
	
	public void cleanTIMER(){
		this.TI = 0;
	}

	public void update() {
		this.TI = 10;
	}
}
