public class FoxAndClassroom {
	public String ableTo(int n, int m) {
		return gcd(n, m) == 1 ? "Possible" : "Impossible";
	}

	int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
