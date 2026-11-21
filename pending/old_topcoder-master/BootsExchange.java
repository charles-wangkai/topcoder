import java.util.Arrays;

public class BootsExchange {
	public int leastAmount(int[] left, int[] right) {
		int exchangeNum = 0;
		Arrays.sort(left);
		Arrays.sort(right);
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < left.length) {
			if (rightIndex == right.length
					|| left[leftIndex] < right[rightIndex]) {
				leftIndex++;
				exchangeNum++;
			} else if (left[leftIndex] == right[rightIndex]) {
				leftIndex++;
				rightIndex++;
			} else {
				rightIndex++;
			}
		}
		return exchangeNum;
	}
}
