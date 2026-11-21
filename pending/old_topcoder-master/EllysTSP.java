public class EllysTSP {
	public int getMax(String places) {
		int countV = 0;
		for (int i = 0; i < places.length(); i++) {
			if (places.charAt(i) == 'V') {
				countV++;
			}
		}
		return Math.min(Math.min(countV, places.length() - countV) * 2 + 1,
				places.length());
	}
}
