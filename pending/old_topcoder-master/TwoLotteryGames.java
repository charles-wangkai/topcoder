import java.util.ArrayList;
import java.util.Arrays;

public class TwoLotteryGames {
	ArrayList<int[]> allNumbers = new ArrayList<int[]>();

	public double getHigherChanceGame(int n, int m, int k) {
		search(new int[m], n, 0);
		int winNum = 0;
		for (int numbers1[] : allNumbers) {
			for (int numbers2[] : allNumbers) {
				if (isWin(numbers1, numbers2, k)) {
					winNum++;
				}
			}
		}
		return (double) winNum / (allNumbers.size() * allNumbers.size());
	}

	void search(int numbers[], int n, int index) {
		if (index == numbers.length) {
			allNumbers.add(numbers.clone());
			return;
		}
		for (int number = (index == 0) ? 1 : (numbers[index - 1] + 1); number <= n; number++) {
			numbers[index] = number;
			search(numbers, n, index + 1);
		}
	}

	boolean isWin(int numbers1[], int numbers2[], int commonTarget) {
		int commonNum = 0;
		for (int number1 : numbers1) {
			if (Arrays.binarySearch(numbers2, number1) >= 0) {
				commonNum++;
			}
		}
		return commonNum >= commonTarget;
	}
}
