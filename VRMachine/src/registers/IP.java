package registers;

public class IP {
	private int reg = 0;

	public IP() {
		this.reg = 0;
	}

	public IP(int x) {
		this.reg = x;
	}

	public IP(String x) {
		this.reg = Integer.parseInt(x);
	}

	public int get() {
		return this.reg;
	}

	public int getNext() {
		if (this.reg == 0)
			return 0;
		else 
			return this.reg;
	}

	public void set(int value) {
		this.reg = value;
	}

	public void increase() {
		this.reg++;
	}
}
