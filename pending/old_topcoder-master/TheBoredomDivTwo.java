public class TheBoredomDivTwo {
	public int find(int n, int m, int j, int b) {
		int boreNum = n;
		if (j > n) {
			boreNum++;
		}
		if (b > n) {
			boreNum++;
		}
		return boreNum;
	}
}
