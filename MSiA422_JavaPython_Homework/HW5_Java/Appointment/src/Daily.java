import java.time.LocalDate;

public class Daily extends Appointment {
	public String type = "Daily";
	public Integer startYear, startMonth, startDay, endYear, endMonth, endDay;
	private String description;

	// constructor
	public Daily(String description, int startYear, int startMonth, int startDay, int endYear, int endMonth,
			int endDay) {
		this.description = description;
		this.type = "Daily";
		this.startYear = startYear;
		this.startMonth = startMonth;
		this.startDay = startDay;
		this.endYear = endYear;
		this.endMonth = endMonth;
		this.endDay = endDay;
	}

	public boolean occursOn(int year, int month, int day) {
		LocalDate d = LocalDate.of(year, month, day);
		LocalDate start = LocalDate.of(startYear, startMonth, startDay);
		LocalDate end = LocalDate.of(endYear, endMonth, startDay);
		return !(d.isBefore(start) || d.isAfter(end));
	}
	
	public String toString() {
		return "Daily Meeting " +  this.description + " starting from " + this.startYear + "/" + this.startMonth + "/" +this.startDay+ " ending on " + this.endYear + "/" + this.endMonth + "/" +this.endDay + ".";
	}

}
