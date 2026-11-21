public class ElevatorLimit {
	public int[] getRange(int[] enter, int[] exit, int physicalLimit) {
		int delta = 0;
		int minDelta = 0;
		int maxDelta = 0;
		for (int i = 0; i < enter.length; i++) {
			delta -= exit[i];
			minDelta = Math.min(minDelta, delta);
			delta += enter[i];
			maxDelta = Math.max(maxDelta, delta);
		}
		if (maxDelta - minDelta > physicalLimit) {
			return new int[0];
		} else {
			return new int[] { -minDelta, physicalLimit - maxDelta };
		}
	}
}
