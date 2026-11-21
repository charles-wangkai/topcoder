import java.util.Arrays;

public class BridgeCrossing {
	public int minTime(int[] times) {
		if (times.length==1) {
			return times[0];
		}
		Arrays.sort(times);
		int total=0;
		int rest=times.length;
		while (rest>3) {
			total+=Math.min(times[0]*2+times[rest-2]+times[rest-1], times[0]+times[1]*2+times[rest-1]);
			rest-=2;
		}
		if (rest==3) {
			return total+times[0]+times[1]+times[2];
		}
		else if (rest==2) {
			return total+times[1];
		}
		return -1;
	}
}
