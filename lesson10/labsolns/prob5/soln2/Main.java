package lesson10.labsolns.prob5.soln2;

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
	
	public String asString(List<Employee> testList) {
		return testList.stream()
			    .filter(this::salaryGreaterThan100000)
			    .filter(this::lastNameAfterM)
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
	
	public boolean salaryGreaterThan100000(Employee e) {
		return e.getSalary() > 100000;
	}
	public boolean lastNameAfterM(Employee e) {
		return e.getLastName().charAt(0) > 'M';
	}
}
