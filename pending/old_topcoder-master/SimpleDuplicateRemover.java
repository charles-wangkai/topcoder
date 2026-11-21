import java.util.ArrayList;
import java.util.HashSet;

public class SimpleDuplicateRemover {
	public int[] process(int[] sequence) {
		HashSet<Integer> history = new HashSet<Integer>();
		ArrayList<Integer> rest = new ArrayList<Integer>();
		for (int i = sequence.length - 1; i >= 0; i--) {
			if (!history.contains(sequence[i])) {
				history.add(sequence[i]);
				rest.add(0, sequence[i]);
			}
		}
		int result[] = new int[rest.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = rest.get(i);
		}
		return result;
	}
}
