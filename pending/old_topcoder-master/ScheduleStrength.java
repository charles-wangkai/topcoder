import java.util.Arrays;

public class ScheduleStrength {
	public String[] calculate(String[] teams, String[] results) {
		Team teamArr[] = new Team[teams.length];
		for (int i = 0; i < teamArr.length; i++) {
			teamArr[i] = new Team(teams[i]);
			for (int j = 0; j < results[i].length(); j++) {
				char result = results[i].charAt(j);
				if (result == 'W') {
					teamArr[i].win++;
				}
				if (result != '-') {
					teamArr[i].game++;
				}
			}
		}
		for (int i = 0; i < teamArr.length; i++) {
			for (int j = 0; j < results[i].length(); j++) {
				char result = results[i].charAt(j);
				if (result != '-') {
					teamArr[i].opponentsWin += teamArr[j].win
							+ ((result == 'W') ? 0 : -1);
					teamArr[i].opponentsGame += teamArr[j].game - 1;
				}
			}
		}
		Arrays.sort(teamArr);
		String names[] = new String[teamArr.length];
		for (int i = 0; i < names.length; i++) {
			names[i] = teamArr[i].name;
		}
		return names;
	}
}

class Team implements Comparable<Team> {
	String name;
	int win;
	int game;
	int opponentsWin;
	int opponentsGame;

	Team(String name) {
		this.name = name;
	}

	public int compareTo(Team other) {
		int delta = opponentsWin * other.opponentsGame - opponentsGame
				* other.opponentsWin;
		if (delta != 0) {
			return -delta;
		} else {
			return name.compareTo(other.name);
		}
	}
}