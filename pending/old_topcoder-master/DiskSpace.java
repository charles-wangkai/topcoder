import java.util.Arrays;

public class DiskSpace {
	public int minDrives(int[] used, int[] total) {
		int remaining = 0;
		for (int u : used) {
			remaining += u;
		}
		Arrays.sort(total);
		for (int i = total.length - 1;; i--) {
			if (remaining <= 0) {
				return total.length - 1 - i;
			}
			remaining -= total[i];
		}
	}
}
