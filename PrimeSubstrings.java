import java.util.Arrays;
import java.util.stream.Collectors;

public class PrimeSubstrings {
  static final int[][] DIGITS = {
    null,
    {2},
    {1, 1},
    {1, 1, 3},
    {1, 1, 9, 3},
    {1, 1, 9, 3, 9},
    {1, 9, 3, 9, 3, 9},
    {1, 3, 1, 3, 3, 3, 9, 9}
  };

  public String construct(int N, int L) {
    int[] result = new int[N];
    for (int i = 0; i < result.length; ++i) {
      result[i] = DIGITS[L][i % DIGITS[L].length];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining());
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
    System.out.println("]");
    PrimeSubstrings obj;
    String answer;
    obj = new PrimeSubstrings();
    long startTime = System.currentTimeMillis();
    answer = obj.construct(p0, p1);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + "\"" + p2 + "\"");
    }
    System.out.println("Your answer:");
    System.out.println("\t" + "\"" + answer + "\"");
    if (hasAnswer) {
      res = answer.equals(p2);
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
    String p2;

    // ----- test 0 -----
    p0 = 4;
    p1 = 2;
    p2 = "5317";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 7;
    p1 = 7;
    p2 = "1301779";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 5;
    p1 = 4;
    p2 = "13079";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
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
