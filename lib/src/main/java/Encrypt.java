import java.util.HashMap;
import java.util.Map;

public class Encrypt {
  static final char[][] MATRIX = {
    {'A', 'B', 'C', 'D', 'E', 'F'},
    {'G', 'H', 'I', 'J', 'K', 'L'},
    {'M', 'N', 'O', 'P', 'Q', 'R'},
    {'S', 'T', 'U', 'V', 'W', 'X'},
    {'Y', 'Z', '0', '1', '2', '3'},
    {'4', '5', '6', '7', '8', '9'}
  };

  static Map<Character, Point> charToPoint;

  static {
    precompute();
  }

  static void precompute() {
    charToPoint = new HashMap<>();
    for (int r = 0; r < MATRIX.length; ++r) {
      for (int c = 0; c < MATRIX[r].length; ++c) {
        charToPoint.put(MATRIX[r][c], new Point(r, c));
      }
    }
  }

  public String encrypt(String s) {
    Point p1 = charToPoint.get(s.charAt(0));
    Point p2 = charToPoint.get(s.charAt(1));

    return "%c%c".formatted(MATRIX[p1.r()][p2.c()], MATRIX[p2.r()][p1.c()]);
  }
}

record Point(int r, int c) {}
