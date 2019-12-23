package lesson10.labsolns.prob4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GuestListJava8Easy {

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

	private boolean checkLegal(Guest g) throws IllegalGuestException {
		if (g.getStatus() == Status.ILLEGAL)
			throw new IllegalGuestException();
		return true;
	}

	private boolean checkLegalHelper(Guest g) {
		try {
			return checkLegal(g);
		} catch (IllegalGuestException e) {
			throw new RuntimeException(e);
		}
	}

	public void printListOfExpectedFemaleGuests(List<Guest> invited) {
		System.out.println(invited.stream().filter((Guest g) -> checkLegalHelper(g))
				.filter(g -> (g.getGender() == Gender.F)).filter(g -> g.isPlanningToCome()).map(g -> g.getName())
				.sorted().collect(Collectors.joining(", ")));

	}

	public void printListOfExpectedFemaleGuests2(List<Guest> invited) {
		System.out.println(invited.stream().filter((Guest g) -> {
			try {
				return checkLegal(g);
			} catch (IllegalGuestException e) {
				throw new RuntimeException(e);
			}
		}).filter(g -> (g.getGender() == Gender.F)).filter(g -> g.isPlanningToCome()).map(g -> g.getName()).sorted()
				.collect(Collectors.joining(", ")));

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
