package ReadingRoom;

public class Member {
	private String name;
	private String sex;
	private int bYear;
	private int bMonth;
	private int bDay;
	private int number;
	private static boolean entered;
	private int sitNum;
	
	public Member(String name, String sex, int bYear, int bMonth, int bDay, int number, boolean entered, int sitNum) {
		super();
		this.name = name;
		this.sex = sex;
		this.bYear = bYear;
		this.bMonth = bMonth;
		this.bDay = bDay;
		this.number = number;
		Member.entered = entered;
		this.sitNum = sitNum;
	}
	public Member() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getbYear() {
		return bYear;
	}
	public void setbYear(int bYear) {
		this.bYear = bYear;
	}
	public int getbMonth() {
		return bMonth;
	}
	public void setbMonth(int bMonth) {
		this.bMonth = bMonth;
	}
	public int getbDay() {
		return bDay;
	}
	public void setbDay(int bDay) {
		this.bDay = bDay;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public static boolean isEntered() {
		return entered;
	}
	public static void setEntered(boolean entered) {
		Member.entered = entered;
	}
	public int getSitNum() {
		return sitNum;
	}
	public void setSitNum(int sitNum) {
		this.sitNum = sitNum;
	}
	
}
