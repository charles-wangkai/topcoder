import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StringTransformationEasy {
  public String getResult(String s, String t) {
    List<Integer> sCounts = compress(s);
    List<Integer> tCounts = compress(t);

    return (s.charAt(0) == t.charAt(0)
            && sCounts.size() == tCounts.size()
            && ((sCounts.size() == 1 && sCounts.get(0).equals(tCounts.get(0)))
                || (sCounts.size() != 1
                    && IntStream.range(0, sCounts.size())
                        .allMatch(
                            i ->
                                sCounts.get(i) >= tCounts.get(i)
                                    && (sCounts.get(i) - tCounts.get(i)) % 2 == 0))))
        ? "YES"
        : "NO";
  }

  List<Integer> compress(String str) {
    List<Integer> result = new ArrayList<>();
    int count = 1;
    for (int i = 1; i < str.length(); ++i) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        ++count;
      } else {
        result.add(count);
        count = 1;
      }
    }
    result.add(count);

    return result;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, String p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
    System.out.println("]");
    StringTransformationEasy obj;
    String answer;
    obj = new StringTransformationEasy();
    long startTime = System.currentTimeMillis();
    answer = obj.getResult(p0, p1);
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

    String p0;
    String p1;
    String p2;

    // ----- test 0 -----
    p0 = "RRRRGGG";
    p1 = "RRG";
    p2 = "YES";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "RRR";
    p1 = "RRR";
    p2 = "YES";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "RRRGGRRRRGGG";
    p1 = "RGGRRRRG";
    p2 = "YES";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "RRGG";
    p1 = "RRGGGG";
    p2 = "NO";
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "GGGG";
    p1 = "GG";
    p2 = "NO";
    all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
