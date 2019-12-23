package lesson11.labsolns.prob5;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
public class SecondSmallest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4, 2, 3, 6);
		System.out.println(secondSmallest2(list));
		
		List<Employee> list2 
		  = Arrays.asList(new Employee("joe", 10000), new Employee("tom", 200000));
		
		System.out.println(secondSmallest2(list2));
		
		List<LocalDate> dates = Arrays.asList(LocalDate.of(1900, 1, 1), LocalDate.of(1950,1,1),
				LocalDate.of(1975, 1, 1), LocalDate.of(2000, 1, 1));
		
		System.out.println(secondSmallest3(dates));
		
		
		
		
		//using comparators
//		System.out.println(secondSmallest3(list2, new EmployeeNameComparator()));
//	
//		
//		LocalDate secondLargest = secondSmallest4(  //doesn't work with secondSmallest3
//				dates, (ChronoLocalDate d1, ChronoLocalDate d2) -> {if(d1.compareTo(d2) > 0) return -1; 
//				                    else if(d1.compareTo(d2) < 0) return 1;
//				                    else return 0;});
//				
//		System.out.println(secondLargest);
	}
	
	public static Integer secondSmallest(List<Integer> list) {
		int smallest = list.get(0);
		int secondSmallest = list.get(1);
		if(smallest > secondSmallest) {
			int temp = smallest;
			smallest = secondSmallest;
			secondSmallest = temp;
		}
		for(int i = 2; i < list.size(); ++i) {
			int next = list.get(i);
			if(next < smallest) {
				secondSmallest = smallest;
				smallest = next;
			}
			else if(next < secondSmallest) {
				secondSmallest = next;
			}
			
		}
		return secondSmallest;
	}

	
	public static <T extends Comparable<T>> T secondSmallest2(List<T> list) {
		T smallest = list.get(0);
		T secondSmallest = list.get(1);
		if(smallest.compareTo(secondSmallest)>0) {
			T temp = smallest;
			smallest = secondSmallest;
			secondSmallest = temp;
		}
		for(int i = 2; i < list.size(); ++i) {
			T next = list.get(i);
			if(next.compareTo(smallest)<0) {
				secondSmallest = smallest;
				smallest = next;
			}
			else if(next.compareTo(secondSmallest)<0) {
				secondSmallest = next;
			}
			
		}
		return secondSmallest;
	}
	
	public static <T extends Comparable<? super T>> T secondSmallest3(List<T> list) {
		T smallest = list.get(0);
		T secondSmallest = list.get(1);
		if(smallest.compareTo(secondSmallest)>0) {
			T temp = smallest;
			smallest = secondSmallest;
			secondSmallest = temp;
		}
		for(int i = 2; i < list.size(); ++i) {
			T next = list.get(i);
			if(next.compareTo(smallest)<0) {
				secondSmallest = smallest;
				smallest = next;
			}
			else if(next.compareTo(secondSmallest)<0) {
				secondSmallest = next;
			}
			
		}
		return secondSmallest;
	}
	
	/////////Using Comparators
	
	
	public static <T> T secondSmallest4(List<T> list, Comparator<T> comp) {
		T smallest = list.get(0);
		T secondSmallest = list.get(1);
		if(comp.compare(smallest, secondSmallest)>0) {
			T temp = smallest;
			smallest = secondSmallest;
			secondSmallest = temp;
		}
		for(int i = 2; i < list.size(); ++i) {
			T next = list.get(i);
			if(comp.compare(next,smallest)<0) {
				secondSmallest = smallest;
				smallest = next;
			}
			else if(comp.compare(next,secondSmallest)<0) {
				secondSmallest = next;
			}
			
		}
		return secondSmallest;
	}
	
	
	public static <T> T secondSmallest5(List<? extends T> list, Comparator<? super T> comp) {
		T smallest = list.get(0);
		T secondSmallest = list.get(1);
		if(comp.compare(smallest, secondSmallest)>0) {
			T temp = smallest;
			smallest = secondSmallest;
			secondSmallest = temp;
		}
		for(int i = 2; i < list.size(); ++i) {
			T next = list.get(i);
			if(comp.compare(next,smallest)<0) {
				secondSmallest = smallest;
				smallest = next;
			}
			else if(comp.compare(next,secondSmallest)<0) {
				secondSmallest = next;
			}
			
		}
		return secondSmallest;
	}
}
