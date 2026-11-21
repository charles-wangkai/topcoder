public class WaiterTipping {
	public int maxPercent(int total, int taxPercent, int money) {
		int maxTip = -1;
		for (int tip = 0; total + total * taxPercent / 100 + total * tip / 100 <= money; tip++) {
			maxTip = tip;
		}
		return maxTip;
	}
}
