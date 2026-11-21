public class PotatoGame {
	public String theWinner(int n) {
		int mod5 = n % 5;
		if (mod5 == 0 || mod5 == 2) {
			return "Hanako";
		} else {
			return "Taro";
		}
	}
}
