import java.util.ArrayList;

public class SortBooks {
	public int[] checkManually(String[] field1, String[] field2) {
		ArrayList<Integer> manually = new ArrayList<Integer>();
		for (int i = 0; i < field1.length; i++) {
			if (isTitle(field1[i]) == isTitle(field2[i])) {
				manually.add(i);
			}
		}
		int result[] = new int[manually.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = manually.get(i);
		}
		return result;
	}

	boolean isTitle(String str) {
		str = str.toLowerCase();
		String words[] = str.split(" +");
		if (words.length > 3) {
			return true;
		}
		for (String word : words) {
			if (word.equals("the") || word.equals("and") || word.equals("of")) {
				return true;
			}
		}
		return false;
	}
}
