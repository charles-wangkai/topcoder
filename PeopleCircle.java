import java.util.ArrayDeque;
import java.util.Queue;

public class PeopleCircle {
  public String order(int numMales, int numFemales, int K) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < numMales + numFemales; ++i) {
      result.append('M');
    }

    Queue<Integer> rest = new ArrayDeque<>();
    for (int i = 0; i < numMales + numFemales; ++i) {
      rest.offer(i);
    }

    for (int i = 0; i < numFemales; ++i) {
      for (int j = 0; j < (K - 1) % rest.size(); ++j) {
        rest.offer(rest.poll());
      }

      result.setCharAt(rest.poll(), 'F');
    }

    return result.toString();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, int p2, boolean hasAnswer, String p3) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
    System.out.println("]");
    PeopleCircle obj;
    String answer;
    obj = new PeopleCircle();
    long startTime = System.currentTimeMillis();
    answer = obj.order(p0, p1, p2);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + "\"" + p3 + "\"");
    }
    System.out.println("Your answer:");
    System.out.println("\t" + "\"" + answer + "\"");
    if (hasAnswer) {
      res = answer.equals(p3);
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
    String p3;

    // ----- test 0 -----
    p0 = 5;
    p1 = 3;
    p2 = 2;
    p3 = "MFMFMFMM";
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 7;
    p1 = 3;
    p2 = 1;
    p3 = "FFFMMMMMMM";
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 25;
    p1 = 25;
    p2 = 1000;
    p3 = "MMMMMFFFFFFMFMFMMMFFMFFFFFFFFFMMMMMMMFFMFMMMFMFMMF";
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 5;
    p1 = 5;
    p2 = 3;
    p3 = "MFFMMFFMFM";
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 1;
    p1 = 0;
    p2 = 245;
    p3 = "M";
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
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
