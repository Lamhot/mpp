package lesson10.labsolns.prob5.soln2_general;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
	
	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		(new Main()).printEmps(emps);
	}
	
	public static final double LOWER_SALARY = 100000;
	public static final char LOWER_CHAR = 'M'; 
	
	public String asString(List<Employee> testList) {
		return testList.stream()
			    .filter(this::salaryGreaterThanLower)
			    .filter(this::lastNameAfterChar)
			    .map(this::fullName)
			    .sorted()
			    .collect(Collectors.joining(", "));
	}
	public void printEmps(List<Employee> list) {
		System.out.println(asString(list));
		
			               
	}
	public String fullName(Employee e) {
		return e.getFirstName() + " " + e.getLastName();
	}
	
	public boolean salaryGreaterThanLower(Employee e) {
		return e.getSalary() > LOWER_SALARY;
	}
	public boolean lastNameAfterChar(Employee e) {
		return e.getLastName().charAt(0) > LOWER_CHAR;
	}
}
