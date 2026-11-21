import java.util.ArrayList;

public class InstantRunoffVoting {
	public int winner(String[] voters) {
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		for (int number = 0; number < voters[0].length(); number++) {
			candidates.add(new Candidate(number));
		}
		while (!candidates.isEmpty()) {
			for (String voter : voters) {
				int voteNumber = voter.charAt(0) - '0';
				for (Candidate candidate : candidates) {
					if (candidate.number == voteNumber) {
						candidate.voteNum++;
						break;
					}
				}
			}
			int minVoteNum = Integer.MAX_VALUE;
			for (Candidate candidate : candidates) {
				if (candidate.voteNum * 2 > voters.length) {
					return candidate.number;
				}
				minVoteNum = Math.min(minVoteNum, candidate.voteNum);
			}
			for (int i = 0; i < candidates.size(); i++) {
				if (candidates.get(i).voteNum == minVoteNum) {
					for (int j = 0; j < voters.length; j++) {
						voters[j] = voters[j].replace(candidates.get(i).number
								+ "", "");
					}
					candidates.remove(i);
					i--;
				} else {
					candidates.get(i).voteNum = 0;
				}
			}
		}
		return -1;
	}
}

class Candidate {
	int number;
	int voteNum;

	public Candidate(int number) {
		this.number = number;
	}
}