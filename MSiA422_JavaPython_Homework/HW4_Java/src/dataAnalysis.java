import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Employee implements Comparable<Employee>{

	private Integer salary;
	private String name;
	private String dob;
	private Integer year = 2021;
	private Integer dobYear;

	// constructor
	public Employee(String name, String dob, Integer salary) {
		this.name = name;
		this.dob = dob;
		this.salary = salary;
	}

	// Creat methods to get the name, dob, Salary
	public String getName() {
		return this.name;
	}

	public String getDob() {
		return this.dob;
	}

	public Integer getSalary() {
		return this.salary;
	}

	// Calculate age by 1. get the year this employee born in, 2. use the current year - the dob year + 1
	public Integer getAge() {
		dobYear = Integer.parseInt(this.dob.substring(this.dob.length() - 4));
		return year - dobYear + 1;
	}

	// Override compareTo, compare two employee based on their salary. 
	public int compareTo(Employee o) {
		if (this.getSalary() > o.getSalary()) {
			return 1;
		} else if (this.getSalary() < o.getSalary()) {
			return -1;
		}
		return 0;
	}
}

public class dataAnalysis {

	public static int countEmployee(ArrayList<Employee> emList) {
		return emList.size();
	}

	public static String maxSalary(ArrayList<Employee> emList) {
		Employee max = Collections.max(emList);
		return max.getName();
	}

	public static float avgSalary(ArrayList<Employee> emList) {
		int sum = 0;
		for (int i = 0; i < emList.size(); i++) {
			sum += emList.get(i).getSalary();
		}
		return sum / (float) emList.size();
	}

	public static int aboveAvg(ArrayList<Employee> emList) {
		int count = 0;
		float avg = avgSalary(emList);

		for (int i = 0; i < emList.size(); i++) {
			if (emList.get(i).getSalary() > avg) {
				count++;
			}
		}
		return count;
	}

	public static double avgAge(ArrayList<Employee> emList) {
		int sum = 0;
		for (int i = 0; i < emList.size(); i++) {
			sum += emList.get(i).getAge();
		}
		return sum / (double) emList.size();
	}

	public static void main(String[] args) throws IOException {
		File txt = new File("employees.txt");
		try (Scanner sc = new Scanner(txt)) {
			ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();

			while (sc.hasNextLine()) {
				String raw = sc.nextLine();
				String[] eachEmployee = raw.split(",");
				
				String name = eachEmployee[0];
				String dob = eachEmployee[1];
				Integer salary = Integer.parseInt(eachEmployee[2]);
				
				employeeArrayList.add(new Employee(name, dob, salary));
			}
			
			// How many Employees exist in the file? 
			System.out.println("There are " + countEmployee(employeeArrayList) + " employees.");
			
			// Who has the highest salary? 
			System.out.println(maxSalary(employeeArrayList) + " has the highest salary.");
			
			// What is the average salary? 
			System.out.println("The average salary is " + avgSalary(employeeArrayList) + ".");
			
			// How many employees make above the average? 
			System.out.println(aboveAvg(employeeArrayList) + " employees make above average.");
			
			// What is the average age of employees? 
			System.out.println("The average age is " + avgAge(employeeArrayList) + ".");
			
			// Write to an output file the employee names sorted according to their salary?
			FileWriter writer = new FileWriter("output.txt");
			ArrayList<String> sorted = new ArrayList<String>();
			Collections.sort(employeeArrayList);
			Collections.reverse(employeeArrayList);
			
			for (int i = 0; i < employeeArrayList.size(); i++) {
			    sorted.add(employeeArrayList.get(i).getName() + "," + employeeArrayList.get(i).getDob() + "," + employeeArrayList.get(i).getSalary());
			}
			
			for(String str: sorted) {
			    writer.write(str + System.lineSeparator());
			}
			writer.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
