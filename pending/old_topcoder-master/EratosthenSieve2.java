import java.util.ArrayList;

public class EratosthenSieve2 {
	public int nthElement(int n) {
		ArrayList<Integer> N = new ArrayList<Integer>();
		for (int i = 1; i <= 1000; i++) {
			N.add(i);
		}
		for (int i = 2; i <= 10; i++) {
			for (int j = N.size() / i * i - 1; j >= 0; j -= i) {
				N.remove(j);
			}
		}
		return N.get(n - 1);
	}
}
