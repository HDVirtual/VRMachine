package registers;

public class TimerMechRegister {
	private int TIMER;
	public TimerMechRegister(int TI) {
		this.TIMER = TI;
	}

	public int get() {
		return this.TIMER;
	}

	public void update() {
		if (this.TIMER > 0) {
			this.TIMER = this.TIMER - 1;
		} else {
			this.TIMER = this.TIMER - 1;
			RM.RM.MODE.set(1);
			reset();
		}
	}
	
	public void cleanTIMER(){
		this.TIMER = 0;
	}

	public void reset() {
		this.TIMER = 10;
	}
}
