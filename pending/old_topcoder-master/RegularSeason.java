import java.util.Arrays;

public class RegularSeason {
	public String[] finalStandings(String[] teams, int rounds) {
		int teamNum = teams.length;
		Team t[] = new Team[teamNum];
		int probs[][] = new int[teamNum][teamNum];
		for (int i = 0; i < teamNum; i++) {
			String fields[] = teams[i].split(" ");
			t[i] = new Team(fields[0]);
			for (int j = 0; j < teamNum; j++) {
				probs[i][j] = Integer.parseInt(fields[j + 1]);
			}
		}
		for (int i = 0; i < teamNum; i++) {
			for (int j = 0; j < teamNum; j++) {
				if (j == i) {
					continue;
				}
				t[i].win100 += probs[i][j] * rounds;
				t[j].win100 += (100 - probs[i][j]) * rounds;
			}
		}
		Arrays.sort(t);
		String result[] = new String[teamNum];
		for (int i = 0; i < teamNum; i++) {
			result[i] = t[i].name + " " + (t[i].win100 + 50) / 100;
		}
		return result;
	}
}

class Team implements Comparable<Team> {
	String name;
	int win100 = 0;

	Team(String name) {
		this.name = name;
	}

	public int compareTo(Team other) {
		if (win100 != other.win100) {
			return other.win100 - win100;
		} else {
			return name.compareTo(other.name);
		}
	}
}