import java.util.Arrays;
import java.util.stream.IntStream;

public class TheShuttles {
	public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
		return IntStream.range(1, Arrays.stream(cnt).max().getAsInt() + 1)
				.map(x -> computeCost(cnt, baseCost, seatCost, x)).min().getAsInt();
	}

	int computeCost(int[] cnt, int baseCost, int seatCost, int x) {
		return Arrays.stream(cnt).map(c -> divideToCeil(c, x)).sum() * (baseCost + x * seatCost);
	}

	int divideToCeil(int x, int y) {
		return x / y + ((x % y == 0) ? 0 : 1);
	}
}
