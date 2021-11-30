import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Appointment {

	abstract public boolean occursOn(int year, int month, int day);

	public Appointment() {
	}

	// addApp function allows user to add an appointment.
	public static ArrayList<Appointment> addApp(ArrayList<Appointment> appt) {

		@SuppressWarnings("resource")
		Scanner sc0 = new Scanner(System.in);
		int choice = 0;

		while (choice != 4) {
			try {
				System.out.println("Please select which type of appointment you want to add.");
				System.out.println("Type in 1 if you want to add an ONE TIME appointment.");
				System.out.println("Type in 2 if you want to add a DAILY appointment.");
				System.out.println("Type in 3 if you want to add an MONTHLY appointment.");
				System.out.println("Type in 4 if you want to exit.");
				choice = sc0.nextInt();

				if (choice == 1) {
					System.out.println("You are adding an ONE TIME appointment.");
					System.out.println("Please enter the description of this appointment.");
					String description = sc0.next();
					System.out.println("Please enter the YEAR of this appointment.");
					int year = sc0.nextInt();
					System.out.println("Please enter the MONTH of this appointment.");
					int month = sc0.nextInt();
					System.out.println("Please enter the DAY of this appointment.");
					int day = sc0.nextInt();

					appt.add(new Onetime(description, year, month, day));
					System.out.println("Adding appointment");
					System.out.println((appt.get(appt.size() - 1)).toString());
					System.out.println("...added");

				}

				else if (choice == 2) {
					System.out.println("You are adding a DAILY appointment.");
					System.out.println("Please enter the description of this appointment.");
					String description = sc0.next();
					System.out.println("Please enter the START YEAR of this appointment.");
					int startYear = sc0.nextInt();
					System.out.println("Please enter the START MONTH of this appointment.");
					int startMonth = sc0.nextInt();
					System.out.println("Please enter the START DAY of this appointment.");
					int startDay = sc0.nextInt();
					System.out.println("Please enter the END YEAR of this appointment.");
					int endYear = sc0.nextInt();
					System.out.println("Please enter the END MONTH of this appointment.");
					int endMonth = sc0.nextInt();
					System.out.println("Please enter the END DAY of this appointment.");
					int endDay = sc0.nextInt();
					appt.add(new Daily(description, startYear, startMonth, startDay, endYear, endMonth, endDay));

					System.out.println("Adding appointment");
					System.out.println((appt.get(appt.size() - 1)).toString());
					System.out.println("...added");
				}

				else if (choice == 3) {
					System.out.println("You are adding a MONTHLY appointment.");
					System.out.println("Please enter the description of this appointment.");
					String description = sc0.next();
					System.out.println("Please enter the START YEAR of this appointment.");
					int startYear = sc0.nextInt();
					System.out.println("Please enter the START MONTH of this appointment.");
					int startMonth = sc0.nextInt();
					System.out.println("Please enter the END YEAR of this appointment.");
					int endYear = sc0.nextInt();
					System.out.println("Please enter the END MONTH of this appointment.");
					int endMonth = sc0.nextInt();
					System.out.println("Please enter the DAY of this appointment.");
					int day = sc0.nextInt();
					appt.add(new Monthly(description, startYear, startMonth, endYear, endMonth, day));

					System.out.println("Adding appointment");
					System.out.println((appt.get(appt.size() - 1)).toString());
					System.out.println("...added");
				} else {
					System.out.println("exited!");
				}
			} catch (Exception e) {
				System.out.println("input invalid, please type in 1, 2, 3, 4");
				choice = 4;
			}
		}
		return appt;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Appointment> sampleAppt = new ArrayList<Appointment>();
		ArrayList<Appointment> appt = new ArrayList<Appointment>();
		sampleAppt.add(new Daily("Daily Appt. Sample 1", 2021, 1, 1, 2022, 2, 1));
		sampleAppt.add(new Monthly("Monthly Appt. Sample 1", 2021, 1, 2022, 2, 1));
		sampleAppt.add(new Onetime("One Time Appt. Sample 1", 2021, 1, 1));
		sampleAppt.add(new Daily("Daily Appt. Sample 2", 2021, 1, 2, 2022, 2, 4));
		sampleAppt.add(new Monthly("Monthly Appt. Sample 2", 2021, 2, 2022, 2, 4));
		sampleAppt.add(new Onetime("One Time Appt. Sample 2", 2021, 2, 4));
		int choice = 0;

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("This program have some sample appointments.");
			System.out.println("If you want to use this existing list of appointments, please type in 1.");
			System.out.println("If you want to start with an empty list, please type in 2.");
			choice = sc.nextInt();

			if (choice == 1) {
				appt = sampleAppt;
				System.out.println("Sample list loaded!");
				System.out.println("There are currently " + appt.size() + " appointments in your list.");
			} else if (choice == 2) {
				System.out.println("Empty list created!");
				System.out.println("There are currently " + appt.size() + " appointments in your list.");
			}

			choice = 0;
			while (choice != 5) {
				@SuppressWarnings("resource")
				Scanner sc1 = new Scanner(System.in);

				System.out.println("If you want to add one/some appointment(s), please type in 1.");
				System.out.println("If you want to load this list of appointment(s) to a text file, please type in 2.");
				System.out.println(
						"If you want to check whether there is an appointment occurs on a date, please type in 3.");
				System.out.println("If you want to get all appointments that occurs on one date, please type in 4.");
				System.out.println("If you want to exit, please type in 5");
				choice = sc1.nextInt();

				if (choice == 1) {
					appt = addApp(appt);
					System.out.println(
							"If you want to check your current list, please type in 1. Ignore and proceed, please type in 0.");
					if (sc.nextInt() == 1) {
						for (int i = 0; i < appt.size(); i++) {
							System.out.println(appt.get(i).toString());
						}
					}
				}

				else if (choice == 2) {
					FileWriter writer = new FileWriter("appointment.txt");
					ArrayList<String> arr = new ArrayList<String>();
					for (int i = 0; i < appt.size(); i++) {
						arr.add(appt.get(i).toString());
					}
					for (String str : arr) {
						writer.write(str + System.lineSeparator());
					}
					writer.close();
				}

				else if (choice == 3) {
					System.out.println("Enter the year of the date to Check:");
					int checkYear = sc.nextInt();
					System.out.println("Enter the month of the date to Check:");
					int checkMonth = sc.nextInt();
					System.out.println("Enter the day of the date to Check:");
					int checkDay = sc.nextInt();
					int sum = 0;
					for (int i = 0; i < appt.size(); i++) {
						sum += appt.get(i).occursOn(checkYear, checkMonth, checkDay) ? 1 : 0;
					}

					if (sum != 0) {
						System.out.println("There is at least one appointment on this day.");
					} else {
						System.out.println("There is no appointment scheduled on this day.");
					}
				}

				else if (choice == 4) {
					System.out.println("Enter the year of the date to Check:");
					int checkYear = sc.nextInt();
					System.out.println("Enter the month of the date to Check:");
					int checkMonth = sc.nextInt();
					System.out.println("Enter the day of the date to Check:");
					int checkDay = sc.nextInt();

					for (int i = 0; i < appt.size(); i++) {
						if (appt.get(i).occursOn(checkYear, checkMonth, checkDay)) {
							System.out.println(appt.get(i).toString());
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println("input invalid.");
			choice = 5;
		}

	}

}
