/**
 * ADD DESCRIPTION!!!!
 *
 * @author sagesilberman
 *
 */
public class BDayM {
	private int roomFolks; // people count in room
	private int duplicates; // people duplicate of b-days

	/**
	 * Constructs an BDayM with the number of people in a room and number of
	 * duplicate birthdays in that room
	 * 
	 * @param people the number of people in room
	 * @param dup    the number of duplicate birthday's
	 */
	public BDayM(int people, int dup) {
		roomFolks = people;
		duplicates = dup;
	}

	/**
	 * Returns <code>true</code> if the random birthday being tested is the same as
	 * the ones set to <code>true</code>
	 * 
	 * @return <code>true</code> if the random birthday being tested is the same as
	 *         the ones set to true ; <code>false</code> otherwise is false
	 * 
	 */
	public boolean runTest() {
		int[] days = new int[30]; // range of score board
		// initially set all days to 0
		for (int d = 0; d < 30; d++) {
			days[d] = d;
		}
		int ranDay;
		for (int p = 0; p < roomFolks; p++) {
			ranDay = genDay(); // generate a random day
			// if ranDay location already true, then there's a match
			days[ranDay]++;
			if (days[ranDay] == duplicates) {
				return true;
			} else {
			}
		}
		return false;
	}

	/**
	 * Returns a random number between 0 and 30
	 * 
	 * @return random number between 0 and 30
	 */
	private int genDay() {
		// no leap year - just gen a random day 0-364
		return ((int) (30 * Math.random()));
	}
}