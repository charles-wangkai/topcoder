public class ScoringEfficiency {
	public double getPointsPerShot(String[] gameLog) {
		int point = 0;
		int fieldAttempt = 0;
		int freeAttempt = 0;
		for (String log : gameLog) {
			if (log.equals("Made 2 point field goal")) {
				fieldAttempt++;
				point += 2;
			} else if (log.equals("Missed 2 point field goal")) {
				fieldAttempt++;
			} else if (log.equals("Made 3 point field goal")) {
				fieldAttempt++;
				point += 3;
			} else if (log.equals("Missed 3 point field goal")) {
				fieldAttempt++;
			} else {
				freeAttempt++;
				if (log.equals("Made free throw")) {
					point++;
				}
			}
		}
		return point / (fieldAttempt + 0.5 * freeAttempt);
	}
}
