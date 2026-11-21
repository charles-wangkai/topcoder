import java.util.ArrayList;
import java.util.Arrays;

public class TheLotteryBothDivs {
	public double find(String[] goodSuffixes) {
		final int ZERO_NUM = 9;
		ArrayList<String> simplifiedSuffixes = new ArrayList<String>(
				Arrays.asList(goodSuffixes));
		for (int i = 0; i < simplifiedSuffixes.size(); i++) {
			for (int j = 0; j < simplifiedSuffixes.size(); j++) {
				if (j == i) {
					continue;
				}
				if (simplifiedSuffixes.get(i).endsWith(
						simplifiedSuffixes.get(j))) {
					simplifiedSuffixes.remove(i);
					i--;
					break;
				}
			}
		}
		int prizeTotal = 0;
		for (String simplifiedSuffix : simplifiedSuffixes) {
			prizeTotal += pow10(ZERO_NUM - simplifiedSuffix.length());
		}
		return (double) prizeTotal / pow10(ZERO_NUM);
	}

	int pow10(int exponent) {
		int power = 1;
		for (int i = 0; i < exponent; i++) {
			power *= 10;
		}
		return power;
	}
}
