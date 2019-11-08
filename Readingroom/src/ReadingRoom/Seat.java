package ReadingRoom;

public class Seat {
	private int number;
	private boolean available;
	private static int count;
	
	public Seat(int number, boolean available) {
		super();
		this.number = number;
		this.available = available;
		
		if(available==true) {count++;}
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
		
		if(available==true) {count++;}
		else {count--;}
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Seat.count = count;
	}
}
