public class DeckRearranging {
	public String rearrange(String deck, int[] above) {
		String newDeck = "";
		for (int i = 0; i < deck.length(); i++) {
			newDeck = newDeck.substring(0, above[i]) + deck.charAt(i)
					+ newDeck.substring(above[i]);
		}
		return newDeck;
	}
}
