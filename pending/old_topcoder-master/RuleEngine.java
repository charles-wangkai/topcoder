import java.math.BigInteger;

public class RuleEngine {
	boolean used[];
	boolean possibles[][];

	public String countSets(String[] ruleSet1, String[] ruleSet2) {
		used = new boolean[26];
		possibles = new boolean[26][21];
		dispose(ruleSet1);
		dispose(ruleSet2);
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < 26; i++) {
			if (used[i]) {
				int count = 0;
				for (int j = 0; j <= 20; j++) {
					if (possibles[i][j]) {
						count++;
					}
				}
				result = result.multiply(new BigInteger(count + ""));
			}
		}
		return result.toString();
	}

	void dispose(String ruleSet[]) {
		for (int i = 0; i < ruleSet.length; i++) {
			int index = ruleSet[i].charAt(0) - 'A';
			if (ruleSet[i].charAt(1) == 'B') {
				String str[] = ruleSet[i].substring(2).split(",");
				int lower = Integer.parseInt(str[0]);
				int upper = Integer.parseInt(str[1]);
				if (used[index]) {
					for (int j = -10; j < lower; j++) {
						possibles[index][j + 10] = false;
					}
					for (int j = upper + 1; j <= 10; j++) {
						possibles[index][j + 10] = false;
					}
				} else {
					used[index] = true;
					for (int j = lower; j <= upper; j++) {
						possibles[index][j + 10] = true;
					}
				}
			} else if (ruleSet[i].charAt(1) == '='
					&& ruleSet[i].charAt(2) == '=') {
				int data = Integer.parseInt(ruleSet[i].substring(3));
				if (used[index]) {
					for (int j = -10; j < data; j++) {
						possibles[index][j + 10] = false;
					}
					for (int j = data + 1; j <= 10; j++) {
						possibles[index][j + 10] = false;
					}
				} else {
					used[index] = true;
					possibles[index][data + 10] = true;
				}
			} else if (ruleSet[i].charAt(1) == '<') {
				int upper;
				if (ruleSet[i].charAt(2) == '=') {
					upper = Integer.parseInt(ruleSet[i].substring(3));
				} else {
					upper = Integer.parseInt(ruleSet[i].substring(2)) - 1;
				}
				if (used[index]) {
					for (int j = upper + 1; j <= 10; j++) {
						possibles[index][j + 10] = false;
					}
				} else {
					used[index] = true;
					for (int j = -10; j <= upper; j++) {
						possibles[index][j + 10] = true;
					}
				}
			} else if (ruleSet[i].charAt(1) == '>') {
				int lower;
				if (ruleSet[i].charAt(2) == '=') {
					lower = Integer.parseInt(ruleSet[i].substring(3));
				} else {
					lower = Integer.parseInt(ruleSet[i].substring(2)) + 1;
				}
				if (used[index]) {
					for (int j = -10; j < lower; j++) {
						possibles[index][j + 10] = false;
					}
				} else {
					used[index] = true;
					for (int j = lower; j <= 10; j++) {
						possibles[index][j + 10] = true;
					}
				}
			} else if (ruleSet[i].charAt(1) == '!') {
				int data = Integer.parseInt(ruleSet[i].substring(3));
				if (used[index]) {
					possibles[index][data + 10] = false;
				} else {
					used[index] = true;
					for (int j = -10; j < data; j++) {
						possibles[index][j + 10] = true;
					}
					for (int j = data + 1; j <= 10; j++) {
						possibles[index][j + 10] = true;
					}
				}
			}
		}
	}
}
