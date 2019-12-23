package lesson10.lab.part2.prob10a;

import java.util.*;
public class Or {

	public static void main(String[] args) {
		List<Simple> list = Arrays.asList(new Simple(false), new Simple(false), new Simple(true));
		list.forEach(x -> System.out.println(x.toString()));

	}

	public boolean someSimpleIsTrue(List<Simple> list) {
		boolean accum = false;
		if (list == null) {
			return false;
		}

		accum = list.stream().map(l -> l.flag).reduce(false, (x, y) -> x || y);

		return accum;
	}

}
