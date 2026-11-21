public class LateProfessor {
	public double getProbability(int waitTime, int walkTime, int lateTime,
			int bestArrival, int worstArrival) {
		if (walkTime <= lateTime) {
			return 0;
		}
		int total = 0;
		for (int begin = waitTime, end = waitTime + walkTime - lateTime; begin < worstArrival; begin += waitTime
				+ walkTime, end += waitTime + walkTime) {
			if (end < bestArrival) {
				continue;
			}
			if (bestArrival == worstArrival) {
				return 1;
			}
			total += Math.min(end, worstArrival) - Math.max(begin, bestArrival);
		}
		if (bestArrival == worstArrival) {
			return 0;
		} else {
			return (double) total / (worstArrival - bestArrival);
		}
	}
}
