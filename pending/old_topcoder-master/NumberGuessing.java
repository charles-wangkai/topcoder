import java.util.Arrays;

public class NumberGuessing {
	int upper;
	int guessed[];

	public int bestGuess(int range, int[] guesses, int numLeft) {
		upper = range;
		guessed = new int[guesses.length + numLeft + 1];
		for (int i = 0; i < guesses.length; i++) {
			guessed[i] = guesses[i];
		}
		return search(numLeft);
	}

	int search(int rest) {
		int chance = 0;
		int choice;
		if (rest == 0) {
			if (guessed.length == 1) {
				return guessed[0] = 1;
			} else {
				int temp[] = new int[guessed.length - 1];
				System.arraycopy(guessed, 0, temp, 0, temp.length);
				Arrays.sort(temp);
				chance = temp[0] - 1;
				choice = temp[0] - 1;
				for (int i = 0; i < temp.length - 1; i++) {
					if (temp[i + 1] > temp[i] + 1
							&& (temp[i + 1] - temp[i] - 2) / 2 + 1 > chance) {
						chance = (temp[i + 1] - temp[i] - 2) / 2 + 1;
						choice = temp[i] + 1;
					}
				}
				if (upper - temp[temp.length - 1] > chance) {
					chance = upper - temp[temp.length - 1];
					choice = temp[temp.length - 1] + 1;
				}
				return guessed[guessed.length - 1] = choice;
			}
		} else {
			int best[] = new int[guessed.length];
			for (int i = 1; i <= upper; i++) {
				boolean used = false;
				for (int j = 0; j < guessed.length - rest - 1; j++) {
					if (guessed[j] == i) {
						used = true;
						break;
					}
				}
				if (!used) {
					guessed[guessed.length - rest - 1] = i;
					search(rest - 1);
					int temp = calculate(i);
					if (temp > chance) {
						chance = temp;
						choice = i;
						System.arraycopy(guessed, 0, best, 0, best.length);
					}
				}
			}
			System.arraycopy(best, 0, guessed, 0, best.length);
			return guessed[guessed.length - rest - 1];
		}
	}

	int calculate(int number) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < guessed.length; i++) {
			if (guessed[i] < number) {
				min = Math.max(min, guessed[i]);
			} else if (guessed[i] > number) {
				max = Math.min(max, guessed[i]);
			}
		}
		return 1
				+ (min == Integer.MIN_VALUE ? number - 1
						: (number - min - 1) / 2)
				+ (max == Integer.MAX_VALUE ? upper - number
						: (max - number - 1) / 2);
	}
}
