public class IncredibleMachineEasy {
	public double gravitationalAcceleration(int[] height, int T) {
		double sqrtSum = 0;
		for (int h : height) {
			sqrtSum += Math.sqrt(h);
		}
		return sqrtSum * sqrtSum * 2 / T / T;
	}
}
