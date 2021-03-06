import java.time.LocalDate;

public class Monthly extends Appointment {
	public String type = "Monthly";
	public Integer startYear, startMonth, endYear, endMonth, day;
	private String description;

	// constructor
	public Monthly(String description, int startYear, int startMonth, int endYear, int endMonth, int day) {
		this.description = description;
		this.type = "Monthly";
		this.startYear = startYear;
		this.startMonth = startMonth;
		this.endYear = endYear;
		this.endMonth = endMonth;
		this.day = day;
	}

	public boolean occursOn(int year, int month, int day) {
		LocalDate d = LocalDate.of(year, month, day);
		LocalDate start = LocalDate.of(startYear, startMonth, this.day);
		LocalDate end = LocalDate.of(endYear, endMonth, this.day);
//		return (d.isBefore(end) && d.isAfter(start) && d.getDayOfMonth() == this.day);
		return (!(d.isBefore(start) || d.isAfter(end)) && d.getDayOfMonth() == this.day);
	}

	
	public String toString() {
		return "Monthly Meeting " +  this.description + " starting in " + this.startYear + "/" + this.startMonth + " ending in " + this.endYear + "/" + this.endMonth + " occurs on the " + this.day + ".";
	}

}
