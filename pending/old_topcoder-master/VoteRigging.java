public class VoteRigging {
	public int minimumVotes(int[] votes) {
		int changeNum = 0;
		if (votes.length > 1) {
			while (true) {
				int maxVoteIndex = 1;
				for (int i = 2; i < votes.length; i++) {
					if (votes[i] > votes[maxVoteIndex]) {
						maxVoteIndex = i;
					}
				}
				if (votes[0] > votes[maxVoteIndex]) {
					break;
				}
				votes[0]++;
				votes[maxVoteIndex]--;
				changeNum++;
			}
		}
		return changeNum;
	}
}
