
public enum Weekday {

	MONDAY("Monday"), TUESDAY("Tuesday"), WEDNSDAY("Wednsday"), THURSDAY("Thursday"), FRIDAY("Friday"),
	SATURDAY("Saturday"), SUNDAY("Sunday");

	private String selectedDay;

	Weekday(String day) {
		this.selectedDay = day;
	}

	public String getSelectedDay() {
		return selectedDay;
	}
	
	
}
