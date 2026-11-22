public class GCF {
  public int Factor(int x, int y) {
    return (y == 0) ? x : Factor(y, x % y);
  }
}
