import java.util.ArrayList;
import java.util.HashSet;

public class Generators {
	public int[] find(int p) {
		ArrayList<Integer> generators = new ArrayList<Integer>();
		for (int i = 2; i < p; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			int number = 1;
			for (int j = 0; j < p - 1; j++) {
				set.add(number);
				number = number * i % p;
			}
			boolean valid = true;
			for (int j = 1; j < p; j++) {
				if (!set.contains(j)) {
					valid = false;
					break;
				}
			}
			if (valid) {
				generators.add(i);
			}
		}
		int result[] = new int[generators.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = generators.get(i);
		}
		return result;
	}
}
