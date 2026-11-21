public class LotteryTicket {
	public String buy(int price, int b1, int b2, int b3, int b4) {
		for (int i1 = 0; i1 <= 1; i1++) {
			for (int i2 = 0; i2 <= 1; i2++) {
				for (int i3 = 0; i3 <= 1; i3++) {
					for (int i4 = 0; i4 <= 1; i4++) {
						if (b1 * i1 + b2 * i2 + b3 * i3 + b4 * i4 == price) {
							return "POSSIBLE";
						}
					}
				}
			}
		}
		return "IMPOSSIBLE";
	}
}
