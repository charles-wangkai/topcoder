public class TrueSpace {
	public long calculateSpace(int[] sizes, int clusterSize) {
		long actualTotal = 0;
		for (int size : sizes) {
			actualTotal += (long) Math.ceil((double) size / clusterSize)
					* clusterSize;
		}
		return actualTotal;
	}
}
