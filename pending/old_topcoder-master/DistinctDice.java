import java.util.Arrays;

public class DistinctDice {
	public int getDistinct(String[] givenDice) {
		for (int i = 0; i < givenDice.length; i++) {
			givenDice[i] = rotateTop1(givenDice[i]);
			if (givenDice[i].charAt(1) != '2') {
				givenDice[i] = rotateLeft2(givenDice[i]);
			} else {
				givenDice[i] = rotateLeft3(givenDice[i]);
			}
		}
		Arrays.sort(givenDice);
		int count = 1;
		for (int i = 1; i < givenDice.length; i++) {
			if (givenDice[i].compareTo(givenDice[i - 1]) != 0) {
				count++;
			}
		}
		return count;
	}

	String rotateTop1(String dice) {
		if (dice.charAt(0) == '1') {
			return dice;
		}
		if (dice.charAt(1) == '1') {
			return "1" + dice.charAt(0) + dice.charAt(2) + dice.charAt(3)
					+ dice.charAt(5) + dice.charAt(4);
		}
		if (dice.charAt(2) == '1') {
			return "1" + dice.charAt(3) + dice.charAt(1) + dice.charAt(0)
					+ dice.charAt(4) + dice.charAt(5);
		}
		if (dice.charAt(3) == '1') {
			return "1" + dice.charAt(2) + dice.charAt(0) + dice.charAt(1)
					+ dice.charAt(4) + dice.charAt(5);
		}
		if (dice.charAt(4) == '1') {
			return "1" + dice.charAt(5) + dice.charAt(2) + dice.charAt(3)
					+ dice.charAt(1) + dice.charAt(0);
		}
		if (dice.charAt(5) == '1') {
			return "1" + dice.charAt(4) + dice.charAt(2) + dice.charAt(3)
					+ dice.charAt(0) + dice.charAt(1);
		}
		return null;
	}

	String rotateLeft2(String dice) {
		if (dice.charAt(2) == '2') {
			return dice;
		}
		if (dice.charAt(3) == '2') {
			return "1" + dice.charAt(1) + "2" + dice.charAt(2) + dice.charAt(5)
					+ dice.charAt(4);
		}
		if (dice.charAt(4) == '2') {
			return "1" + dice.charAt(1) + "2" + dice.charAt(5) + dice.charAt(3)
					+ dice.charAt(2);
		}
		if (dice.charAt(5) == '2') {
			return "1" + dice.charAt(1) + "2" + dice.charAt(4) + dice.charAt(2)
					+ dice.charAt(3);
		}
		return null;
	}

	String rotateLeft3(String dice) {
		if (dice.charAt(2) == '3') {
			return dice;
		}
		if (dice.charAt(3) == '3') {
			return "123" + dice.charAt(2) + dice.charAt(5) + dice.charAt(4);
		}
		if (dice.charAt(4) == '3') {
			return "123" + dice.charAt(5) + dice.charAt(3) + dice.charAt(2);
		}
		if (dice.charAt(5) == '3') {
			return "123" + dice.charAt(4) + dice.charAt(2) + dice.charAt(3);
		}
		return null;
	}
}
