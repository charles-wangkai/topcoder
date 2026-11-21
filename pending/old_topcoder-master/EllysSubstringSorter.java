import java.util.Arrays;
import java.util.stream.IntStream;

public class EllysSubstringSorter {
	public String getMin(String S, int L) {
		return IntStream.rangeClosed(0, S.length() - L).mapToObj(startIndex -> modify(S, L, startIndex))
				.reduce((result, element) -> element.compareTo(result) < 0 ? element : result).get();
	}

	String modify(String s, int L, int startIndex) {
		return s.substring(0, startIndex) + reorder(s.substring(startIndex, startIndex + L))
				+ s.substring(startIndex + L);
	}

	String reorder(String s) {
		char[] chs = s.toCharArray();
		Arrays.sort(chs);
		return new String(chs);
	}
}
