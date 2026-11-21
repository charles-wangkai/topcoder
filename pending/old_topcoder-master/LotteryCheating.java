import java.util.ArrayList;

public class LotteryCheating {
	public int minimalChange(String ID) {
		ArrayList<String> winnings = new ArrayList<String>();
		for (int i = 0;; i++) {
			String winning = (long) i * i + "";
			if (winning.length() > ID.length()) {
				break;
			}
			winnings.add(winning);
		}
		int minChange = Integer.MAX_VALUE;
		for (String winning : winnings) {
			int change = computeChange(winning, ID);
			minChange = Math.min(minChange, change);
		}
		return minChange;
	}

	int computeChange(String ticket1, String ticket2) {
		int lengthDiff = ticket1.length() - ticket2.length();
		if (lengthDiff < 0) {
			for (int i = 0; i < -lengthDiff; i++) {
				ticket1 = "0" + ticket1;
			}
		} else if (lengthDiff > 0) {
			for (int i = 0; i < lengthDiff; i++) {
				ticket2 = "0" + ticket2;
			}
		}
		int change = 0;
		for (int i = 0; i < ticket1.length(); i++) {
			if (ticket1.charAt(i) != ticket2.charAt(i)) {
				change++;
			}
		}
		return change;
	}
}
