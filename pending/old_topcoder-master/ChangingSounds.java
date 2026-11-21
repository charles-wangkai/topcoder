import java.util.TreeSet;

public class ChangingSounds {
	public int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel) {
		TreeSet<Integer> volumes = new TreeSet<Integer>();
		volumes.add(beginLevel);
		for (int changeInterval : changeIntervals) {
			TreeSet<Integer> nextVolumes = new TreeSet<Integer>();
			for (int volume : volumes) {
				int candidates[] = { volume + changeInterval,
						volume - changeInterval };
				for (int candidate : candidates) {
					if (candidate >= 0 && candidate <= maxLevel) {
						nextVolumes.add(candidate);
					}
				}
			}
			volumes = nextVolumes;
		}
		if (volumes.isEmpty()) {
			return -1;
		} else {
			return volumes.last();
		}
	}
}
