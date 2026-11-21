public class Seconds {
  public int[] getMinutes(int seconds) {
    return new int[] {seconds / 60, seconds % 60};
  }
}
