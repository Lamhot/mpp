package lesson10.labs.part2.prob12;

public class Main {

	public static void main(String[] args) {
		MySingletonLazy instance1 = MySingletonLazy.getInstance();
		MySingletonLazy instance2 = MySingletonLazy.getInstance();
	
		System.out.println(instance1.equals(instance2));
		
	}

}
