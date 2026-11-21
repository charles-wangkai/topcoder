import java.util.TreeSet;

public class Sets {
	public int[] operate(int[] A, int[] B, String operation) {
		TreeSet<Integer> setA = buildSet(A);
		TreeSet<Integer> setB = buildSet(B);
		TreeSet<Integer> setResult;
		if (operation.equals("UNION")) {
			setA.addAll(setB);
			setResult = setA;
		} else if (operation.equals("INTERSECTION")) {
			setResult = new TreeSet<Integer>();
			for (int itemA : setA) {
				if (setB.contains(itemA)) {
					setResult.add(itemA);
				}
			}
		} else {
			setResult = new TreeSet<Integer>();
			for (int itemA : setA) {
				if (!setB.contains(itemA)) {
					setResult.add(itemA);
				}
			}
			for (int itemB : setB) {
				if (!setA.contains(itemB)) {
					setResult.add(itemB);
				}
			}
		}
		int result[] = new int[setResult.size()];
		int index = 0;
		for (int item : setResult) {
			result[index] = item;
			index++;
		}
		return result;
	}

	TreeSet<Integer> buildSet(int a[]) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int item : a) {
			set.add(item);
		}
		return set;
	}
}
