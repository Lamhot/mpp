package lesson10.labsolns.prob5.soln1;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TestMain {
	@Test
	public void testAsString() {
		Employee e1 = new Employee("Joe", "Andrews", 90000); //should not be included
		Employee e2 = new Employee("Tom", "Wilson", 75000); //should not be included
		Employee e3 = new Employee("Bill", "Richards", 120000); //should be included
		List<Employee> testList = Arrays.asList(new Employee[]{e1, e2, e3});
		String output = (new Main()).asString(testList);
		assertEquals("Bill Richards", output);
	}
}
