import java.util.Arrays;

public class Workshop {
  public int pictureFrames(int[] pieces) {
    Arrays.sort(pieces);

    int result = 0;
    for (int i = 0; i < pieces.length; ++i) {
      for (int j = i + 1; j < pieces.length; ++j) {
        for (int k = j + 1; k < pieces.length; ++k) {
          if (pieces[i] + pieces[j] > pieces[k]) {
            ++result;
          }
        }
      }
    }

    return result;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}");
    System.out.println("]");
    Workshop obj;
    int answer;
    obj = new Workshop();
    long startTime = System.currentTimeMillis();
    answer = obj.pictureFrames(p0);
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

    int[] p0;
    int p1;

    // ----- test 0 -----
    p0 = new int[] {1, 2, 3, 4, 5};
    p1 = 3;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {8, 5, 3};
    p1 = 0;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {4, 23, 76, 22, 87, 3, 1, 99};
    p1 = 7;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {10000, 9999, 9998, 9997, 9996, 1, 2, 3, 4, 5};
    p1 = 43;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new int[] {100};
    p1 = 0;
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
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
