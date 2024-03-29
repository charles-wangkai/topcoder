import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BrickByBrick {
  public int timeToClear(String[] map) {
    int row = map.length;
    int col = map[0].length();

    int rest = 0;
    char[][] cells = new char[row][col];
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        cells[r][c] = map[r].charAt(c);
        if (cells[r][c] == 'B') {
          ++rest;
        }
      }
    }

    int time = 0;
    int x = 1;
    int y = 0;
    int dx = 1;
    int dy = 1;
    Set<State> states = new HashSet<>();
    states.add(new State(x, y, dx, dy));
    while (true) {
      int r = (y % 2 == 0) ? Math.floorDiv(y + dy, 2) : (y / 2);
      int c = (x % 2 == 0) ? Math.floorDiv(x + dx, 2) : (x / 2);

      if (r >= 0 && r < row && c >= 0 && c < col && cells[r][c] == '.') {
        x += dx;
        y += dy;

        ++time;
      } else {
        if (r >= 0 && r < row && c >= 0 && c < col && cells[r][c] == 'B') {
          cells[r][c] = '.';
          --rest;
          if (rest == 0) {
            return time;
          }

          states.clear();
        }

        if (x % 2 == 0) {
          dx *= -1;
        } else {
          dy *= -1;
        }
      }

      if (!states.add(new State(x, y, dx, dy))) {
        return -1;
      }
    }
  }

  class State {
    int x;
    int y;
    int dx;
    int dy;

    State(int x, int y, int dx, int dy) {
      this.x = x;
      this.y = y;
      this.dx = dx;
      this.dy = dy;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y, dx, dy);
    }

    @Override
    public boolean equals(Object obj) {
      State other = (State) obj;

      return x == other.x && y == other.y && dx == other.dx && dy == other.dy;
    }
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    BrickByBrick obj;
    int answer;
    obj = new BrickByBrick();
    long startTime = System.currentTimeMillis();
    answer = obj.timeToClear(p0);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p1);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p1;
    }
    if (!res) {
      System.out.println("DOESN'T MATCH!!!!");
    } else if ((endTime - startTime) / 1000.0 >= 2) {
      System.out.println("FAIL the timeout");
      res = false;
    } else if (hasAnswer) {
      System.out.println("Match :-)");
    } else {
      System.out.println("OK, but is it right?");
    }
    System.out.println("");
    return res;
  }

  public static void main(String[] args) {
    boolean all_right;
    all_right = true;

    String[] p0;
    int p1;

    // ----- test 0 -----
    p0 = new String[] {".B", "BB"};
    p1 = 6;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {".BB", "BBB", "BBB"};
    p1 = -1;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"......B", "###.###", "B.....B"};
    p1 = 35;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 =
        new String[] {
          "..BBB...",
          ".#BB..#.",
          "B.#B.B..",
          "B.B.....",
          "##.B.B#.",
          "#BB.#.B.",
          "B..B.BB.",
          "#..BB..B",
          ".B....#."
        };
    p1 = -1;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 =
        new String[] {
          ".BB..BBB.B...",
          "B.B...B..BB..",
          "#B...B#B.....",
          "B#B.B##...##B",
          "BB.B#.B##B.B#",
          "B.B#.BBB.BB#B",
          "B#BBB##.#B#B.",
          "B#BB.BBB#BB.#"
        };
    p1 = 3912;
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 =
        new String[] {
          ".BBBBBBBBBBBBBB",
          "##############B",
          "BBBBBBBBBBBBBBB",
          "B##############",
          "BBBBBBBBBBBBBBB",
          "##############B",
          "BBBBBBBBBBBBBBB",
          "B##############",
          "BBBBBBBBBBBBBBB",
          "##############B",
          "BBBBBBBBBBBBBBB",
          "B##############",
          "BBBBBBBBBBBBBBB",
          "##############B",
          "BBBBBBBBBBBBBBB"
        };
    p1 = 31753;
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    if (all_right) {
      System.out.println("You're a stud (at least on the example cases)!");
    } else {
      System.out.println("Some of the test cases had errors.");
    }
  }
  // END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
