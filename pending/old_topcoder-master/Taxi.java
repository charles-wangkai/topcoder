public class Taxi {
	public double maxDis(int maxX, int maxY, int taxiDis) {
		if (maxX + maxY < taxiDis) {
			return -1;
		}
		long length = Math.min(Math.max(maxX, maxY), taxiDis);
		long width = taxiDis - length;
		return Math.sqrt(length * length + width * width);
	}
}
