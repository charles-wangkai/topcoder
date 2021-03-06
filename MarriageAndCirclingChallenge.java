public class MarriageAndCirclingChallenge {
  int state;

  public long solve(int N, int threshold, int state) {
    this.state = state;

    boolean[][] loves = new boolean[N][N];
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        if (rnd() < threshold) {
          loves[i][j] = true;
        } else {
          loves[j][i] = true;
        }
      }
    }

    int[][] twoWayNums = new int[N][N];
    for (int k = 0; k < N; ++k) {
      for (int i = 0; i < N; ++i) {
        if (loves[i][k]) {
          for (int j = 0; j < N; ++j) {
            if (loves[k][j]) {
              ++twoWayNums[i][j];
            }
          }
        }
      }
    }

    long result = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        result += twoWayNums[i][j] * twoWayNums[j][i];
      }
    }
    result /= 4;

    return result;
  }

  int rnd() {
    state = (int) ((state * 1103515245L + 12345) % (1L << 31));

    return state % 100;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, int p2, boolean hasAnswer, long p3) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
    System.out.println("]");
    MarriageAndCirclingChallenge obj;
    long answer;
    obj = new MarriageAndCirclingChallenge();
    long startTime = System.currentTimeMillis();
    answer = obj.solve(p0, p1, p2);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p3);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p3;
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

    int p0;
    int p1;
    int p2;
    long p3;

    // ----- test 0 -----
    p0 = 10;
    p1 = 0;
    p2 = 12345;
    p3 = 0L;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 5;
    p1 = 50;
    p2 = 47;
    p3 = 4L;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 9;
    p1 = 20;
    p2 = 1234567;
    p3 = 29L;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 600;
    p1 = 50;
    p2 = 1234567;
    p3 = 2005430424L;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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
