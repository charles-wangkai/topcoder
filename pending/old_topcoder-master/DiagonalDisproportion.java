public class DiagonalDisproportion {
	public int getDisproportion(String[] matrix) {
		int disproportion = 0;
		for (int i = 0; i < matrix.length; i++) {
			disproportion += matrix[i].charAt(i)
					- matrix[i].charAt(matrix.length - 1 - i);
		}
		return disproportion;
	}
}
