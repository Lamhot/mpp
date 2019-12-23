package lesson10.labsolns.prob4;

import java.util.Arrays;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		final boolean yes = true;
		final boolean no = false;
		GuestListJava8Easy gl = new GuestListJava8Easy();
		List<Guest> invited = Arrays.asList(new Guest("Joe Stevens", Status.COMMON, Gender.M, 5, yes),
				new Guest("Susan Richards", Status.GOLD, Gender.F, 10, no),
				new Guest("Toni Smith", Status.COMMON, Gender.F, 4, yes),
				new Guest("Anthony Hawkins", Status.ILLEGAL, Gender.M, 0, yes),
				new Guest("Tony Thomas", Status.SILVER, Gender.M, 8, no),
				new Guest("Antoinette Cerisier", Status.SILVER, Gender.F, 7, yes),
				new Guest("Ricardo Salhuega", Status.COMMON, Gender.M, 2, yes));

		gl.printListOfExpectedFemaleGuests(invited);

	}
	
	public boolean checkStatus(List<Guest> g) throws IllegalGuestExeption
	{
		return false;
		
	}

	class IllegalGuestExeption extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		IllegalGuestExeption() {
			super("Invalid");
		}

		IllegalGuestExeption(String msg) {
			super(msg);
		}

		IllegalGuestExeption(Throwable throwable) {
			super(throwable);
		}

		IllegalGuestExeption(String msg, Throwable throwable) {
			super(msg, throwable);
		}

	}

}
