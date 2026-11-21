public class CircleGame {
	public int cardsLeft(String deck) {
		deck=deck.replaceAll("K", "");
		boolean found;
		do {
			found=false;
			if (deck.length()>1) {
				for (int i=0;i<deck.length();i++) {
					if (getValue(deck.charAt(i))+getValue(deck.charAt((i+1)%deck.length()))==13) {
						String temp="";
						for (int j=(i+2)%deck.length();j!=i;j=(j+1)%deck.length()) {
							temp+=deck.charAt(j);
						}
						deck=temp;
						found=true;
						break;
					}
				}
			}
		} while (found);
		return deck.length();
	}
	
	int getValue(char card) {
		if (card>='2' && card<='9') {
			return card-'0';
		}
		else if (card=='A') {
			return 1;
		}
		else if (card=='T') {
			return 10;
		}
		else if (card=='J') {
			return 11;
		}
		else if (card=='Q') {
			return 12;
		}
		else if (card=='K') {
			return 13;
		}
		return -1;
	}
}
