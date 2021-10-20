public class BDay {
	private int roomFolks; // people count in room

	public BDay(int people) {
		roomFolks = people;
	}

	public boolean runTest() {
		boolean[] days = new boolean[365]; // boolean scoreboard
		// initially set all days to false
		for (int d = 0; d < 365; d++) {
			days[d] = false;
		}
		int ranDay;
		for (int p = 0; p < roomFolks; p++) {
			ranDay = genDay(); // generate a random day
			// if ranDay location already true, then there's a match
			if (days[ranDay] == true) {
				return true;
			} else {
				days[ranDay] = true;
			}
		}
		return false;
	}

	private int genDay() {
		// no leap year - just gen a random day 0-364
		return ((int) (365 * Math.random()));
	}
}