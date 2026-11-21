import java.util.HashMap;

public class TheTournament {
	public String findLeader(String[] matches) {
		HashMap<String, Player> name2player = new HashMap<String, Player>();
		for (String match : matches) {
			String fields[] = match.split(" ");
			Player playerWin = findPlayer(name2player, fields[0]);
			Player playerLost = findPlayer(name2player, fields[2]);
			playerWin.win++;
			playerLost.lost++;
		}
		Player leader = null;
		for (Player player : name2player.values()) {
			if (leader == null
					|| leader.getMatch() == 0
					|| player.win * leader.getMatch() > leader.win
							* player.getMatch()
					|| (player.win * leader.getMatch() == leader.win
							* player.getMatch() && player.name
							.compareTo(leader.name) < 0)) {
				leader = player;
			}
		}
		return leader.name;
	}

	Player findPlayer(HashMap<String, Player> name2player, String name) {
		if (name2player.containsKey(name)) {
			return name2player.get(name);
		} else {
			Player player = new Player(name);
			name2player.put(name, player);
			return player;
		}
	}
}

class Player {
	String name;
	int win;
	int lost;

	Player(String name) {
		this.name = name;
	}

	int getMatch() {
		return win + lost;
	}
}