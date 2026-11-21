public class ProductionOptimization {
	int cache[][][];
	int typeNumber;
	int costs[];
	int times[];

	public int getMost(int[] costs, int[] times, int totCost, int totTime) {
		this.costs = costs;
		this.times = times;
		typeNumber = costs.length;
		cache = new int[typeNumber][totCost + 1][totTime + 1];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[0].length; j++) {
				for (int k = 0; k < cache[0][0].length; k++) {
					cache[i][j][k] = -1;
				}
			}
		}
		return mem(0, totCost, totTime);
	}

	public int mem(int index, int totCost, int totTime) {
		if (index == typeNumber) {
			return 1;
		}
		if (cache[index][totCost][totTime] > -1) {
			return cache[index][totCost][totTime];
		}
		int ret = 0;
		int leftCost = totCost - costs[index];
		int leftTime = totTime - times[index];
		if (leftTime < 0) {
			return cache[index][totCost][totTime] = 0;
		}
		for (int c = 0; c <= leftCost; c++) {
			int temp = mem(index + 1, c, leftTime)
					+ mem(index, leftCost - c, leftTime);
			ret = Math.max(ret, temp);
		}
		return cache[index][totCost][totTime] = ret;
	}
}
