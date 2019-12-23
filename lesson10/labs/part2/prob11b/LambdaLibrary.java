package lesson10.labs.part2.prob11b;

import java.util.List;

public class LambdaLibrary {
	public static final 
	TriFunction<List<Employee>, Integer, String, String> CRITERIA 
		  = (list, salary, regex) -> list.stream()
										 .filter(emp -> emp.getSalary() > salary)
										 .filter(emp -> emp.getLastName().matches(regex))
										 .map(emp -> emp.getFirstName() + " " + emp.getLastName())
										 .sorted()
										 .reduce((x, y) -> x + ", " + y).get();
}
