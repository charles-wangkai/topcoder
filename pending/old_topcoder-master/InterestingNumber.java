import java.util.stream.IntStream;

public class InterestingNumber {
	public String isInteresting(String x) {
		return IntStream.range(0, 10).allMatch(digit -> isValid(x, digit)) ? "Interesting" : "Not interesting";
	}

	boolean isValid(String x, int digit) {
		char ch = (char) (digit + '0');

		int index1 = x.indexOf(ch);
		if (index1 < 0) {
			return true;
		}

		int index2 = x.indexOf(ch, index1 + 1);
		if (index2 < 0 || index2 - index1 != digit + 1) {
			return false;
		}

		return x.indexOf(ch, index2 + 1) < 0;
	}
}
