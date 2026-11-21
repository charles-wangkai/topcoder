import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Paintball {
	public String[] getLeaderboard(String[] players, String[] messages) {
		HashMap<String, Team> name2team = new HashMap<String, Team>();
		HashMap<String, Player> name2player = new HashMap<String, Player>();
		for (String onePlayers : players) {
			String fields[] = onePlayers.split(" ");
			String playerName = fields[0];
			String teamName = fields[1];
			if (!name2team.containsKey(teamName)) {
				name2team.put(teamName, new Team(teamName));
			}
			Team team = name2team.get(teamName);
			Player player = new Player(playerName, team);
			name2player.put(playerName, player);
			team.players.add(player);
		}
		for (String message : messages) {
			String fields[] = message.split(" ");
			Player from = name2player.get(fields[0]);
			Player to = name2player.get(fields[2]);
			if (from.team == to.team) {
				from.score--;
			} else {
				from.score++;
				to.score--;
			}
		}
		ArrayList<Team> teams = new ArrayList<Team>(name2team.values());
		for (Team team : teams) {
			team.calcScore();
			Collections.sort(team.players);
		}
		Collections.sort(teams);
		ArrayList<String> result = new ArrayList<String>();
		for (Team team : teams) {
			result.add(team.name + " " + team.score);
			for (Player player : team.players) {
				result.add("  " + player.name + " " + player.score);
			}
		}
		return result.toArray(new String[0]);
	}
}

class Player implements Comparable<Player> {
	String name;
	int score = 0;
	Team team;

	public Player(String name, Team team) {
		this.name = name;
		this.team = team;
	}

	public int compareTo(Player another) {
		if (score != another.score) {
			return another.score - score;
		} else {
			return name.compareTo(another.name);
		}
	}
}

class Team implements Comparable<Team> {
	String name;
	int score = 0;
	ArrayList<Player> players = new ArrayList<Player>();

	public Team(String name) {
		this.name = name;
	}

	void calcScore() {
		score = 0;
		for (Player player : players) {
			score += player.score;
		}
	}

	public int compareTo(Team another) {
		if (score != another.score) {
			return another.score - score;
		} else {
			return name.compareTo(another.name);
		}
	}
}