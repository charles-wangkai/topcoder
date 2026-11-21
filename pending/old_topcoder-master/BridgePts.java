import java.util.Arrays;

public class BridgePts {
	public int pointValue(int[] hand) {
		Arrays.sort(hand);
		int point = 0;
		point += count(hand, new int[] { 1, 14, 27, 40 }) * 4;
		point += count(hand, new int[] { 13, 26, 39, 52 }) * 3;
		point += count(hand, new int[] { 12, 25, 38, 51 }) * 2;
		point += count(hand, new int[] { 11, 24, 37, 50 });
		for (int i = 0; i < 4; i++) {
			int suitCount = count(hand, range(i * 13 + 1, i * 13 + 14));
			if (suitCount == 2) {
				point += 1;
			} else if (suitCount == 1) {
				point += 2;
			} else if (suitCount == 0) {
				point += 3;
			}
		}
		return point;
	}

	int count(int hand[], int numbers[]) {
		int result = 0;
		for (int number : numbers) {
			if (Arrays.binarySearch(hand, number) >= 0) {
				result++;
			}
		}
		return result;
	}

	int[] range(int begin, int end) {
		int result[] = new int[end - begin];
		for (int i = 0; i < result.length; i++) {
			result[i] = begin + i;
		}
		return result;
	}
}
