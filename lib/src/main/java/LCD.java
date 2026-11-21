public class LCD {
  public int Denominator(int x, int y) {
    return x / gcd(x, y) * y;
  }

  int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
