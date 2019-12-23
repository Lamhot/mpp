package lesson10.labs.part2.prob12;

import java.util.Optional;

public class MySingletonLazy {
	private static MySingletonLazy instance = null;
	private MySingletonLazy() {}
	
	public static MySingletonLazy getInstance() {
		instance = Optional.ofNullable(instance).orElse(new MySingletonLazy());
		return instance;
	};	
	
	
}
