import java.util.ArrayList;
import java.util.Collections;

public class RabbitVoting {
	public String getWinner(String[] names, String[] votes) {
		ArrayList<String> validVotes = new ArrayList<String>();
		for (int i = 0; i < names.length; i++) {
			if (!names[i].equals(votes[i])) {
				validVotes.add(votes[i]);
			}
		}
		Collections.sort(validVotes);
		int maxVoteNum = -1;
		String winner = null;
		int voteNum = -1;
		for (int i = 0; i <= validVotes.size(); i++) {
			if (i > 0 && i < validVotes.size()
					&& validVotes.get(i).equals(validVotes.get(i - 1))) {
				voteNum++;
			} else {
				if (voteNum > maxVoteNum) {
					maxVoteNum = voteNum;
					winner = validVotes.get(i - 1);
				} else if (voteNum == maxVoteNum) {
					winner = "";
				}
				voteNum = 1;
			}
		}
		return winner;
	}
}
