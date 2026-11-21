import java.util.Arrays;
import java.util.HashMap;

public class NumberMagicEasy {
	public int theNumber(String answer) {
		int card[][] = { { 1, 2, 3, 4, 5, 6, 7, 8 },
				{ 1, 2, 3, 4, 9, 10, 11, 12 }, { 1, 2, 5, 6, 9, 10, 13, 14 },
				{ 1, 3, 5, 7, 9, 11, 13, 15 } };
		HashMap<String, Integer> answer2number = new HashMap<String, Integer>();
		for (int i = 1; i <= 16; i++) {
			String ans = "";
			for (int j = 0; j < 4; j++) {
				ans += (Arrays.binarySearch(card[j], i) >= 0) ? "Y" : "N";
			}
			answer2number.put(ans, i);
		}
		return answer2number.get(answer);
	}
}
