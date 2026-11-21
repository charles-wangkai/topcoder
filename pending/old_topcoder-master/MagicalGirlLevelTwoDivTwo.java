public class MagicalGirlLevelTwoDivTwo {
	public String isReachable(int[] jumpTypes, int x, int y) {
		for (int jumpType : jumpTypes) {
			if (jumpType % 2 == 0) {
				return "YES";
			}
		}
		if ((x + y) % 2 == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
