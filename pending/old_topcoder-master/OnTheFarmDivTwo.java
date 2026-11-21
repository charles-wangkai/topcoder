public class OnTheFarmDivTwo {
	public int[] animals(int heads, int legs) {
		if ((legs - heads * 2) % 2 != 0) {
			return new int[0];
		} else {
			int cows = (legs - heads * 2) / 2;
			int chickens = heads - cows;
			if (chickens < 0 || cows < 0) {
				return new int[0];
			} else {
				return new int[] { chickens, cows };
			}
		}
	}
}
