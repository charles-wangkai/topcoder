import java.util.Arrays;
import java.util.Comparator;

public class TwoWaysSorting {
	public String sortingMethod(String[] stringList) {
		String[] strings = Arrays.copyOf(stringList, stringList.length);

		boolean lexicographically = check(stringList, strings, Comparator.naturalOrder());
		boolean lengths = check(stringList, strings, (s1, s2) -> s1.length() - s2.length());

		String output;
		if (lexicographically && lengths) {
			output = "both";
		} else if (lexicographically && !lengths) {
			output = "lexicographically";
		} else if (!lexicographically && lengths) {
			output = "lengths";
		} else {
			output = "none";
		}
		return output;
	}

	boolean check(String[] stringList, String[] strings, Comparator<String> comparator) {
		Arrays.sort(strings, comparator);
		return Arrays.deepEquals(stringList, strings);
	}
}
