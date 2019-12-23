package lesson10.labs.part2.prob10c;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Prob10c {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream myIntStream = IntStream.of(10, -20, 30, 60, 50, -10);
		IntSummaryStatistics intStream = myIntStream.summaryStatistics();
		System.out.println("Max: " + intStream.getMax());
		System.out.println("Min: " + intStream.getMin());
	}
}
