public class BDayM {
	private int roomFolks; // people count in room
	private int duplicates; // people duplicate of b-days

	public BDayM(int people, int dup) {
		roomFolks = people;
		duplicates = dup;
	}

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

	private int genDay() {
		// no leap year - just gen a random day 0-364
		return ((int) (30 * Math.random()));
	}
}