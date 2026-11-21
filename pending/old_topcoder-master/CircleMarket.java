public class CircleMarket {
	public int makePurchases(int[] openTime, int[] closeTime, int travelTime) {
		int maxCloseTime = -1;
		for (int ct : closeTime) {
			maxCloseTime = Math.max(maxCloseTime, ct);
		}
		int time = 0;
		int store = 0;
		boolean visited[] = new boolean[openTime.length];
		int purchaseNum = 0;
		while (time <= maxCloseTime) {
			if (!visited[store] && time >= openTime[store]
					&& time <= closeTime[store]) {
				visited[store] = true;
				purchaseNum++;
			}
			store = (store + 1) % visited.length;
			time += travelTime;
		}
		return purchaseNum;
	}
}
