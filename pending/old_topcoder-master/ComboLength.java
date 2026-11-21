public class ComboLength {
	public int howLong(String moves) {
		int maxCombo = -1;
		int combo = 1;
		for (int i = 1; i <= moves.length(); i++) {
			if (i < moves.length() && moves.charAt(i) == moves.charAt(i - 1)) {
				combo++;
			} else {
				maxCombo = Math.max(maxCombo, combo);
				combo = 1;
			}
		}
		return maxCombo;
	}
}
