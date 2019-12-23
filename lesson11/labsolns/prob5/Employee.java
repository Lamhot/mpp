package lesson11.labsolns.prob5;

public class Employee implements Comparable<Employee> {
	String name;
	int salary;
	public Employee(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	int getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("name: ");
		sb.append(name);
		sb.append(" salary: ");
		sb.append("" + salary+">");
		return sb.toString();
		
	}
	@Override
	public int compareTo(Employee o) {
		return name.compareTo(o.name);
	}
}

