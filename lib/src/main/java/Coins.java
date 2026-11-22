import java.util.ArrayList;

public class Coins {
  static final int[] VALUES = {25, 10, 5, 1};

  public ArrayList<Integer> getChange(int cents) {
    ArrayList<Integer> result = new ArrayList<>();
    int rest = cents;
    for (int value : VALUES) {
      result.add(rest / value);
      rest %= value;
    }

    return result;
  }
}
