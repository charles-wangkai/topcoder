public class DietPlan {
	public String chooseDinner(String diet, String breakfast, String lunch) {
		boolean remaining[] = new boolean[26];
		for (int i = 0; i < diet.length(); i++) {
			remaining[diet.charAt(i) - 'A'] = true;
		}
		String meals[] = new String[] { breakfast, lunch };
		for (String meal : meals) {
			for (int i = 0; i < meal.length(); i++) {
				int food = meal.charAt(i) - 'A';
				if (!remaining[food]) {
					return "CHEATER";
				}
				remaining[food] = false;
			}
		}
		String dinner = "";
		for (int i = 0; i < remaining.length; i++) {
			if (remaining[i]) {
				dinner += (char) (i + 'A');
			}
		}
		return dinner;
	}
}
