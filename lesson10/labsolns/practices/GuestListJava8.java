package lesson10.labsolns.practices;

import static lesson10.labsolns.prob4.PredicateWithException.unchecked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lesson10.labsolns.prob4.Gender;
import lesson10.labsolns.prob4.Guest;
import lesson10.labsolns.prob4.Status;


public class GuestListJava8 {
	 
	public static void main(String[] args) {
		final boolean yes = true;
		final boolean no = false;
		GuestListJava8 gl = new GuestListJava8();
		List<Guest> invited 
		  = Arrays.asList(new Guest("Joe Stevens", Status.COMMON, Gender.M, 5, yes),
				          new Guest("Susan Richards", Status.GOLD, Gender.F, 10, no),
				          new Guest("Toni Smith", Status.COMMON, Gender.F, 4, yes),
				        //  new Guest("Anthony Hawkins", Status.ILLEGAL, Gender.M, 0, yes),
				          new Guest("Tony Thomas", Status.SILVER, Gender.M, 8, no),
				          new Guest("Antoinette Cerisier", Status.SILVER, Gender.F, 7, yes),
				          new Guest("Ricardo Salhuega", Status.COMMON, Gender.M, 2, yes));
		
		gl.printListOfExpectedFemaleGuests(invited);
		
	}
	private boolean checkLegal(Guest g) throws IllegalGuestException {
		boolean isIllegal = (g.getStatus() == Status.ILLEGAL);
		if(isIllegal) throw new IllegalGuestException(String.format(
					"Illegal guest %s has attempted entry to the event", g.getName()));
		else return true;
		

	}
	 
	public void printListOfExpectedFemaleGuests(List<Guest> invited) {
		//implement
		List<String> namesOfExpected = new ArrayList<>();
		namesOfExpected =invited.stream()
				.filter(g -> unchecked((Guest t) -> checkLegal(t)).test(g))
			//	.filter(g -> unchecked((Guest t) -> checkLegal(t)).test(g))
				
//				.filter(x -> {
//					try {
//						return checkLegal(x);
//					} catch (IllegalGuestException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					return true;
//				})
	
				 .filter(x -> (x.getGender()==Gender.F))
		
				.filter( x->  x.isPlanningToCome())
				.map(x -> x.getName())
				.collect(Collectors.toList());
		System.out.println(namesOfExpected);
				
		
	}
	
	
	class IllegalGuestException extends Exception {
		private static final long serialVersionUID = 1L;
		IllegalGuestException() {
			super("An illegal guest has attempted entry.");
		}
		IllegalGuestException(String msg) {
			super(msg);
		}
		IllegalGuestException(Throwable t) {
			super(t);
		}
	}
}
