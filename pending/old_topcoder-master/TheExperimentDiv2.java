import java.util.Arrays;

public class TheExperimentDiv2 {
	public int[] determineHumidity(int[] intensity, int L, int[] leftEnd) {
		boolean[] canDrops = new boolean[intensity.length];
		Arrays.fill(canDrops, true);

		int[] drops = new int[leftEnd.length];
		for (int i = 0; i < drops.length; i++) {
			for (int j = leftEnd[i]; j < leftEnd[i] + L; j++) {
				if (canDrops[j]) {
					drops[i] += intensity[j];
					canDrops[j] = false;
				}
			}
		}

		return drops;
	}
}
