import java.util.ArrayList;

public class DiceChecker {
	public int[] badValues(int[] values) {
		int counts[] = new int[7];
		for (int i = 0; i < values.length; i++) {
			counts[values[i]]++;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 1; i <= 6; i++) {
			if (counts[i] * 4 > values.length || counts[i] * 10 < values.length) {
				temp.add(i);
			}
		}
		int result[] = new int[temp.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = temp.get(i);
		}
		return result;
	}
}
