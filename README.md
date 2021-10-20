## Programming Project: A Birthday Puzzle Variant

## Clone Project

Begin by cloning the provided project and importing it into your workspace.

`git clone <url for github repository>`

After cloning this repository you want to run these commands

`git checkout -b development`

This will create a branch named development and switch you to it. The development branch is where you will make all your commits.

## Import into Eclipse

You should then go to Eclipse, which hopefully has finished installing.

In the top toolbar, click File --> Import. Double-click on General and then `Projects from Folder or Archive`. Click `Directory` and find the folder inside the repository named `BirthdayPuzzle` and click Open. The project should pop up in the text box Projects. Click finish and you should be good to go!

# Complete Birthday Puzzle Assignment

The birthday puzzle is a famous quirk of elementary probability theory that goes like this: How many people need to be in a room (people chosen at random) before the likelihood that at least two have the same birthday is 50%? (Ignore leap years here: a year is 365 days long for the purposes of this problem). While the naive answer might be 183, it turns out that the actual answer is 23. The attached code solves this problem, and in fact solves the more general problem: if there are K people in a room, where K is any positive integer, what is the probability that at least two of the K people present have the same birthday.

```java
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
```

Your job for this assignment is to write a two-class java program that solves the following variant of the birthday puzzle. Suppose first that a month has exactly 30 days. If there are K people in a room (any positive integral K, K provided interactively), what is the experimental likelihood that at least M of them (any positive integral M, M provided interactively) were born on the same day of the month? This means that if Jack was born on December 17, and Jill on May 17, then they qualify for a match.

Here is output from my solution:

```
> run BDayMTester


	Enter duplicate count
7
       Ok      Cancel


	Now enter the number of people in the room
90
       Ok      Cancel


match chance for 90 people: looking for 7 duplicates
0.655565
```

That is, if there are 90 people in a room, the probability that at least 7 of them were born on the same day of the month is (experimentally) .655565. Notice that this doesn't say which day of the month is involved, just that some day, e.g., the 9th, or the 28th, has at least 7 people with that day of the month as their birthday.

Your two classes should be called BDayMTester and BDayM. Use JOptionPane to obtain inputs. However for output you MUST use System.out.print or System.out.println statements.

Requirement: Base your results, as I have above, on 10,000 trials.

## Notes

- You need to comment your methods according to this [Javadoc Guide](https://github.com/jd12/liferay-portal/blob/master/readme/ADVANCED_JAVADOC_GUIDELINES.markdown).
