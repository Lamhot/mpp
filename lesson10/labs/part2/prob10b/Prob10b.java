package lesson10.labs.part2.prob10b;

import java.util.stream.Stream;

public class Prob10b {
	public static void main(String[] args) {
		System.out.println(Stream.of("Bill", "Thomas", "Mary").reduce((s1, s2) -> s1 + ", " + s2).get());
	}
}
