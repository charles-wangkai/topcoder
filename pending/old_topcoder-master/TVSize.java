public class TVSize {
	public int[] calcSize(int diagonal, int height, int width) {
		double H = Math.sqrt(diagonal * diagonal
				/ ((double) width * width / height / height + 1));
		double W = H * width / height;
		return new int[] { (int) (H + (5E-6)), (int) (W + (5E-6)) };
	}
}
