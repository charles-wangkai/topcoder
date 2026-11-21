import java.util.ArrayList;
import java.util.Collections;

public class DollSets {
	public int maximumQuantity(int[] dollSizes, int K) {
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		for (int dollSize : dollSizes) {
			sizes.add(dollSize);
		}
		Collections.sort(sizes);
		int pairNum = 0;
		for (int i = 0; i < sizes.size(); i++) {
			int size = sizes.get(i);
			int anotherIndex = Collections.binarySearch(
					sizes.subList(i + 1, sizes.size()), size * K);
			if (anotherIndex >= 0) {
				sizes.remove(i + 1 + anotherIndex);
				pairNum++;
			}
		}
		return pairNum;
	}
}
