import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ColorfulStrings {
	ArrayList<String> candidates = new ArrayList<String>();

	public String getKth(int n, int k) {
		if (n > 9) {
			return "";
		}
		if (n == 1) {
			if (k <= 10) {
				return (k - 1) + "";
			} else {
				return "";
			}
		}
		search(new int[n], new boolean[10], 0);
		Collections.sort(candidates);
		for (String candidate : candidates) {
			if (isColorful(candidate)) {
				k--;
				if (k == 0) {
					return candidate;
				}
			}
		}
		return "";
	}

	void search(int[] digits, boolean[] used, int index) {
		if (index == digits.length) {
			String candidate = "";
			for (int digit : digits) {
				candidate += digit;
			}
			candidates.add(candidate);
			return;
		}
		for (int digit = 1; digit <= 9; digit++) {
			if (!used[digit]) {
				used[digit] = true;
				digits[index] = digit;
				search(digits, used, index + 1);
				used[digit] = false;
			}
		}
	}

	boolean isColorful(String candidate) {
		HashSet<Integer> products = new HashSet<Integer>();
		for (int i = 0; i < candidate.length(); i++) {
			int product = 1;
			for (int j = i; j < candidate.length(); j++) {
				product *= candidate.charAt(j) - '0';
				if (products.contains(product)) {
					return false;
				}
				products.add(product);
			}
		}
		return true;
	}
}
