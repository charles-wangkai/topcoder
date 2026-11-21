import java.util.Arrays;

public class CardCount {
	public String[] dealHands(int numPlayers, String deck) {
		int round = deck.length() / numPlayers;
		String hands[] = new String[numPlayers];
		Arrays.fill(hands, "");
		for (int i = 0; i < round; i++) {
			for (int j = 0; j < numPlayers; j++) {
				hands[j] += deck.charAt(i * numPlayers + j);
			}
		}
		return hands;
	}
}
