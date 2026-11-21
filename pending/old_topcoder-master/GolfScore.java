import java.util.HashMap;

public class GolfScore {
	public int tally(int[] parValues, String[] scoreSheet) {
		HashMap<String, Integer> jargon2score = new HashMap<String, Integer>();
		jargon2score.put("triple bogey", 3);
		jargon2score.put("double bogey", 2);
		jargon2score.put("bogey", 1);
		jargon2score.put("par", 0);
		jargon2score.put("birdie", -1);
		jargon2score.put("eagle", -2);
		jargon2score.put("albatross", -3);
		int totalScore = 0;
		for (int i = 0; i < parValues.length; i++) {
			if (scoreSheet[i].equals("hole in one")) {
				totalScore++;
			} else {
				totalScore += parValues[i] + jargon2score.get(scoreSheet[i]);
			}
		}
		return totalScore;
	}
}
