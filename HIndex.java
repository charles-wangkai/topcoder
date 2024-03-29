import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class HIndex {
  public int cheat(int[] realCitations, int budget, int citationPrice) {
    realCitations =
        Arrays.stream(realCitations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int result = -1;
    int lower = 0;
    int upper = realCitations.length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(realCitations, budget / citationPrice, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  boolean check(int[] realCitations, int fakeNum, int hIndex) {
    return IntStream.range(0, hIndex).map(i -> Math.max(0, hIndex - realCitations[i])).sum()
        <= fakeNum;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int[] p0, int p1, int p2, boolean hasAnswer, int p3) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}" + "," + p1 + "," + p2);
    System.out.println("]");
    HIndex obj;
    int answer;
    obj = new HIndex();
    long startTime = System.currentTimeMillis();
    answer = obj.cheat(p0, p1, p2);
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

    int[] p0;
    int p1;
    int p2;
    int p3;

    // ----- test 0 -----
    p0 = new int[] {25, 3, 5, 3, 8, 0};
    p1 = 447;
    p2 = 1000;
    p3 = 3;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {25, 3, 5, 3, 8, 0};
    p1 = 1447;
    p2 = 1000;
    p3 = 4;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
    p1 = 140000;
    p2 = 10000;
    p3 = 4;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {0, 0, 0};
    p1 = 999999999;
    p2 = 1000000000;
    p3 = 0;
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
