import java.util.Arrays;

public class UnluckyNumbers {
	public int getCount(int[] luckySet, int n) {
		Arrays.sort(luckySet);
		int pos = Arrays.binarySearch(luckySet, n);
		if (pos >= 0) {
			return 0;
		}
		pos = -1 - pos;
		int left = (pos == 0) ? n : (n - luckySet[pos - 1]);
		int right = luckySet[pos] - n;
		return left * right - 1;
	}
}
