public class LargestCircle {
  public int radius(String[] grid) {
    int row = grid.length;
    int col = grid[0].length();

    for (int radius = Math.min(row, col) / 2; radius >= 1; --radius) {
      for (int x = radius; x <= row - radius; ++x) {
        for (int y = radius; y <= col - radius; ++y) {
          if (check(grid, x, y, radius)) {
            return radius;
          }
        }
      }
    }

    return 0;
  }

  boolean check(String[] grid, int x, int y, int radius) {
    int row = grid.length;
    int col = grid[0].length();

    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        if (grid[r].charAt(c) == '#') {
          int greaterCount = 0;
          int lessCount = 0;
          for (int i = 0; i <= 1; ++i) {
            for (int j = 0; j <= 1; ++j) {
              int squaredDistance = computeSquaredDistance(x, y, r + i, c + j);
              if (squaredDistance < radius * radius) {
                ++lessCount;
              } else if (squaredDistance > radius * radius) {
                ++greaterCount;
              }
            }
          }

          if (greaterCount != 0 && lessCount != 0) {
            return false;
          }
        }
      }
    }

    return true;
  }

  int computeSquaredDistance(int x1, int y1, int x2, int y2) {
    return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
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
    LargestCircle obj;
    int answer;
    obj = new LargestCircle();
    long startTime = System.currentTimeMillis();
    answer = obj.radius(p0);
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
    p0 = new String[] {"####", "#..#", "#..#", "####"};
    p1 = 1;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 =
        new String[] {
          "############",
          "###......###",
          "##.######.##",
          "#.########.#",
          "#.##..####.#",
          "#.##..####.#",
          "#.########.#",
          "#.########.#",
          "#.########.#",
          "##.######.##",
          "###......###",
          "############"
        };
    p1 = 5;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {".........."};
    p1 = 0;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new String[] {"#######", "#######", "#######", "#######", "#######"};
    p1 = 0;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 =
        new String[] {
          "#####.......",
          "#####.......",
          "#####.......",
          "............",
          "............",
          "............",
          "............",
          "............",
          "............",
          "............"
        };
    p1 = 4;
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 =
        new String[] {
          "#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.",
          "...#...#...#...#...#...#...#...#...#...#...#...#..",
          "#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.",
          ".#...#...#...#...#...#...#...#...#...#...#...#...#",
          "#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.",
          "...#...#...#...#...#...#...#...#...#...#...#...#..",
          "#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.",
          ".#...#...#...#...#...#...#...#...#...#...#...#...#",
          "#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.",
          "...#...#...#...#...#...#...#...#...#...#...#...#.#",
          "#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#."
        };
    p1 = 0;
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 =
        new String[] {
          ".........................#........................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          ".............................................." + "....",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "........................................" + "..........",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          "..................................................",
          ".................................................."
        };
    p1 = 24;
    all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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
