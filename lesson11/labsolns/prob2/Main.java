package lesson11.labsolns.prob2;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4);
		Group<Integer> grp = new Group<>(0, list);
		Group<Integer> copy = (Group<Integer>)GroupUtil.copy(grp);
		System.out.println("Original group: " + grp);
		System.out.println("Copy of group:  " + copy);

	}

}
