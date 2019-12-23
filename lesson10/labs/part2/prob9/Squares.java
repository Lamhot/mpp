package lesson10.labs.part2.prob9;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Squares {

	public static void main(String[] arg) {
		printSquares(7);
	}

	public static void printSquares(int num) {
		System.out.println(Stream.iterate(1, x -> computeSquare(x + 1))//using iterate							
					             .limit(num)
					             .collect(Collectors.toList()));
	}

	private static Integer computeSquare(int i) {
		if ((int) Math.sqrt(i) * Math.sqrt(i) == i)
			return i;
		else
			return computeSquare(i + 1);
	}

}
