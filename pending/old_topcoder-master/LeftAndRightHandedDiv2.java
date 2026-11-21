public class LeftAndRightHandedDiv2 {
	public int count(String S) {
		int result = 0;
		int index = 0;
		while (true) {
			index = S.indexOf("RL", index);
			if (index < 0) {
				break;
			}
			index++;
			result++;
		}
		return result;
	}
}
