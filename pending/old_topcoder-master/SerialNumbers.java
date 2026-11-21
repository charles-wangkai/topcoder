import java.util.Arrays;
import java.util.Comparator;

public class SerialNumbers {
	public String[] sortSerials(String[] serialNumbers) {
		Arrays.sort(serialNumbers, new SerialComparator());
		return serialNumbers;
	}
}

class SerialComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return s1.length() - s2.length();
		}
		int digitSum1 = calcDigitSum(s1);
		int digitSum2 = calcDigitSum(s2);
		if (digitSum1 != digitSum2) {
			return digitSum1 - digitSum2;
		}
		return s1.compareTo(s2);
	}

	int calcDigitSum(String s) {
		int digitSum = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				digitSum += ch - '0';
			}
		}
		return digitSum;
	}
}