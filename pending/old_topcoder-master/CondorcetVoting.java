public class CondorcetVoting {
	public int winner(String[] votes) {
		int candidateNum = votes[0].length();
		int preferCounts[][] = new int[candidateNum][candidateNum];
		for (String vote : votes) {
			for (int i = 0; i < vote.length(); i++) {
				char rankI = vote.charAt(i);
				for (int j = i + 1; j < vote.length(); j++) {
					char rankJ = vote.charAt(j);
					if (rankI < rankJ) {
						preferCounts[i][j]++;
					} else if (rankI > rankJ) {
						preferCounts[j][i]++;
					}
				}
			}
		}
		for (int i = 0; i < candidateNum; i++) {
			boolean winner = true;
			for (int j = 0; j < candidateNum; j++) {
				if (j == i) {
					continue;
				}
				if (preferCounts[i][j] <= preferCounts[j][i]) {
					winner = false;
					break;
				}
			}
			if (winner) {
				return i;
			}
		}
		return -1;
	}
}
