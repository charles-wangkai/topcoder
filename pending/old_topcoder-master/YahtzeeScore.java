public class YahtzeeScore {
	public int maxPoints(int[] toss) {
		int counts[]=new int[7];
		for (int i=0;i<toss.length;i++) {
			counts[toss[i]]++;
		}
		int max=0;
		for (int i=1;i<=6;i++) {
			max=Math.max(max, i*counts[i]);
		}
		return max;
	}
}
