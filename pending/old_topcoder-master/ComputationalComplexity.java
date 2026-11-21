public class ComputationalComplexity {
	public int fastestAlgo(int[] constant, int[] power, int[] logPower, int N) {
		int fastestIndex = -1;
		double fastestOperation = Double.MAX_VALUE;
		for (int i = 0; i < constant.length; i++) {
			double operation = constant[i] * Math.pow(N, power[i])
					* Math.pow(Math.log(N), logPower[i]);
			if (operation < fastestOperation) {
				fastestOperation = operation;
				fastestIndex = i;
			}
		}
		return fastestIndex;
	}
}
