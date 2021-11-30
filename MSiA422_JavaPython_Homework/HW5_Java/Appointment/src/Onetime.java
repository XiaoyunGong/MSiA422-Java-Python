import java.time.LocalDate;

public class Onetime extends Appointment {
	public Integer year, month, day;
	public String type;
	public String description;

// constructor
	public Onetime(String description, int year, int month, int day) {
		this.description = description;
		this.type = "Onetime";
		this.year = year;
		this.day = day;
		this.month = month;
	}

	public boolean occursOn(int testyear, int testmonth, int testday) {
		LocalDate d = LocalDate.of(testyear, testmonth, testday);
		LocalDate appDay = LocalDate.of(year, month, day);
		return d.isEqual(appDay);
	}
	
	public String toString() {
		return "One Time Meeting " +  this.description + " on " + this.year + "/" + this.month + "/" +this.day;
	}

}
