package lesson10.labsolns.prob5.soln2_general;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TestMain {
	@Test
	public void testSalaryGreaterThan100000() {
		Employee e1 = new Employee("Joe", "Andrews", 90000); //should not be included
		Employee e2 = new Employee("Bill", "Richards", 120000); //should be included
		Main m = new Main();
		assertTrue(m.salaryGreaterThanLower(e2));
		assertFalse(m.salaryGreaterThanLower(e1));
	}
	
	public void testLastNameAfterM() {
		Employee e1 = new Employee("Joe", "Andrews", 90000); //should not be included
		Employee e2 = new Employee("Bill", "Richards", 120000); //should be included
		Main m = new Main();
		assertTrue(m.lastNameAfterChar(e2));
		assertFalse(m.salaryGreaterThanLower(e1));
	}
	
	public void testFullName() {
		Employee e1 = new Employee("Joe", "Andrews", 90000); //should not be included
		Main m = new Main();
		assertEquals("Joe Andrews", m.fullName(e1));
	}
}
