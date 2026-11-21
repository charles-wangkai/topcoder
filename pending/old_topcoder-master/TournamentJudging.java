public class TournamentJudging {
	public int getPoints(int[] rawScores, int[] conversionFactor) {
		int point = 0;
		for (int i = 0; i < rawScores.length; i++) {
			point += (int) Math.round((double) rawScores[i]
					/ conversionFactor[i]);
		}
		return point;
	}
}
