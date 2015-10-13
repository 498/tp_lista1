package number;

public class Number {
	public long value;
	
	public Number() {
		value = 0;
	}
	
	public Number(int value) {
		this.value = value;
	}
	
	public Number(String value, int baza) {
		this.value = Long.parseLong(value, baza);
	}
	
	public long get() {
		return value;
	}
	
	public String get(int base) {
		return Long.toString(value, base);
	}
	
	public void set(int value) {
		this.value = value;
	}
	
	public void set(String value, int base) {
		this.value = Long.parseLong(value, base);
	}
}
