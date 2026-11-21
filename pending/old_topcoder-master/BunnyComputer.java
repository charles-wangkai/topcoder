import java.util.ArrayList;

public class BunnyComputer {
	public int getMaximum(int[] preference, int k) {
		int result = 0;
		for (int i = 0; i <= k && i < preference.length; i++) {
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			for (int j = i; j < preference.length; j += k + 1) {
				numbers.add(preference[j]);
			}
			for (int number : numbers) {
				result += number;
			}
			if (numbers.size() % 2 != 0) {
				int removal = Integer.MAX_VALUE;
				for (int j = 0; j < numbers.size(); j += 2) {
					removal = Math.min(removal, numbers.get(j));
				}
				result -= removal;
			}
		}
		return result;
	}
}
