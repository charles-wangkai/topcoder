import java.util.ArrayList;

public class FractionSplit {
	public String[] getSum(int n, int d) {
		ArrayList<String> fractions = new ArrayList<String>();
		while (n != 0) {
			int q = d / n;
			if (d % n != 0) {
				q++;
			}
			fractions.add(1 + "/" + q);
			n = n * q - d;
			d = d * q;
		}
		return fractions.toArray(new String[0]);
	}
}
