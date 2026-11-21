import java.util.Arrays;

public class InverseFactoring {
	public int getTheNumber(int[] factors) {
		Arrays.sort(factors);
		return factors[0] * factors[factors.length - 1];
	}
}
