import java.util.Arrays;

public class CrossCountry {
	public String scoreMeet(int numTeams, String finishOrder) {
		Team teams[] = new Team[numTeams];
		for (int i = 0; i < teams.length; i++) {
			teams[i] = new Team((char) ('A' + i));
		}
		for (int i = 0; i < finishOrder.length(); i++) {
			int index = finishOrder.charAt(i) - 'A';
			if (teams[index].runnerNum == 5) {
				teams[index].sixthPos = i;
			} else if (teams[index].runnerNum < 5) {
				teams[index].score += i + 1;
			}
			teams[index].runnerNum++;
		}
		Arrays.sort(teams);
		String result = "";
		for (Team team : teams) {
			if (team.runnerNum >= 5) {
				result += team.letter;
			}
		}
		return result;
	}
}

class Team implements Comparable<Team> {
	char letter;
	int score = 0;
	int runnerNum = 0;
	int sixthPos = Integer.MAX_VALUE;

	public Team(char letter) {
		this.letter = letter;
	}

	public int compareTo(Team other) {
		if (runnerNum >= 5
				&& (other.runnerNum < 5 || score < other.score || (score == other.score && (sixthPos < other.sixthPos || (sixthPos == other.sixthPos && letter < other.letter))))) {
			return -1;
		} else {
			return 1;
		}
	}
}