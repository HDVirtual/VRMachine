package registers;

public class ModeRegister {
	
	private int Mode;

	public ModeRegister(int x) {
		this.Mode = x;
	}
	/**
	 * Procesoriaus darbo re�imo reik�m�
	 * @return MODE re�imo reik�m�
	 */
	public int get() {
		return this.Mode;
	}
	/**
	 * Procesoriaus darbo re�imo pakeitimas
	 * @param MODE naujas re�imas
	 */
	public void set(int MODE) {
		this.Mode = MODE;
	}
}
