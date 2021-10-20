import javax.swing.JOptionPane;

/**
 * Given any number of people in a room (people ct) what is the experimental
 * probability that two people have the same birthday? Code runs ten-thousand
 * experiments
 */
public class BDayTester {
	public static void main(String[] args) {
		final int trials = 10000;
		String s = JOptionPane.showInputDialog("Enter people ct");
		int count = Integer.parseInt(s);
		BDay bday = new BDay(count);
		int match = 0;
		for (int j = 0; j < trials; j++) {
			if (bday.runTest() == true) {
				match++;
			}
		}
		System.out.print("match chance for " + count + " people: ");
		System.out.println((double) match / trials);
	}
}