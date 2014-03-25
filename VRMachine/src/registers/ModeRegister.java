package registers;

public class ModeRegister {
	
	private int Mode;

	public ModeRegister(int x) {
		this.Mode = x;
	}
	/**
	 * Procesoriaus darbo reþimo reikðmë
	 * @return MODE reþimo reikðmë
	 */
	public int get() {
		return this.Mode;
	}
	/**
	 * Procesoriaus darbo reþimo pakeitimas
	 * @param MODE naujas reþimas
	 */
	public void set(int MODE) {
		this.Mode = MODE;
	}
}
