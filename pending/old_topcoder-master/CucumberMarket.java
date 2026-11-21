import java.util.Arrays;

public class CucumberMarket {
	public String check(int[] price, int budget, int k) {
		return Arrays.stream(price).sorted().skip(price.length - k).sum() <= budget ? "YES"
				: "NO";
	}
}
