public class Average {
	public int belowAvg(int[] math, int[] verbal) {
		int total = 0;
		int childrenNum = math.length;
		for (int i = 0; i < childrenNum; i++) {
			total += math[i] + verbal[i];
		}
		int count = 0;
		for (int i = 0; i < childrenNum; i++) {
			if ((math[i] + verbal[i]) * childrenNum < total) {
				count++;
			}
		}
		return count;
	}
}
