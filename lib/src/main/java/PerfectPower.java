public class PerfectPower {
  public boolean isValid(int x) {
    for (int i = 2; i * i <= x; ++i) {
      int rest = x;
      while (rest % i == 0) {
        rest /= i;
      }
      if (rest == 1) {
        return true;
      }
    }

    return false;
  }
}
