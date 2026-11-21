public class StairClimb {
	public int stridesTaken(int[] flights, int stairsPerStride) {
		int strideNum = (flights.length - 1) * 2;
		for (int flight : flights) {
			strideNum += Math.ceil((double) flight / stairsPerStride);
		}
		return strideNum;
	}
}
