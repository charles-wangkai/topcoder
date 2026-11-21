import java.util.Arrays;

public class UnfairDivision {
	public int albertsShare(int[] assets) {
		int albertMaxShare = 0;
		for (int i = 1; i < assets.length; i++) {
			int bettyMaxShare = 0;
			int albertMinShare = 0;
			for (int j = 1; j < assets.length; j++) {
				if (j == i) {
					continue;
				}
				int minCut = Math.min(i, j);
				int maxCut = Math.max(i, j);
				int shares[] = { assetsSum(assets, 0, minCut),
						assetsSum(assets, minCut, maxCut),
						assetsSum(assets, maxCut, assets.length) };
				Arrays.sort(shares);
				int bettyShare = shares[1];
				int albertShare = shares[0];
				if (bettyShare > bettyMaxShare
						|| (bettyShare == bettyMaxShare && albertShare < albertMinShare)) {
					bettyMaxShare = bettyShare;
					albertMinShare = albertShare;
				}
			}
			albertMaxShare = Math.max(albertMaxShare, albertMinShare);
		}
		return albertMaxShare;
	}

	int assetsSum(int assets[], int begin, int end) {
		int sum = 0;
		for (int i = begin; i < end; i++) {
			sum += assets[i];
		}
		return sum;
	}
}
