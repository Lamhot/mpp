package lesson10.labsolns.practices;

import java.util.function.Predicate;

@FunctionalInterface
public interface PredicateWithException<T> {
	
		public class unchecked {

	}

		boolean test(T t) throws Exception;
		
		public static <T> Predicate<T> unchecked(PredicateWithException<T> p) {
			return t -> {	
				try {
					return p.test(t);
				} catch(Exception e) {
					throw new RuntimeException(e);
				}
			};
		}
	
}
