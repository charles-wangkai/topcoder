import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncorrectCancellation {
  public int find(int D) {
    String s = String.valueOf(D);
    for (int code = 1; code < (1 << s.length()) - 1; ++code) {
      List<Character> crossed = new ArrayList<>();
      StringBuilder rest = new StringBuilder();
      for (int i = 0; i < s.length(); ++i) {
        if ((code & (1 << i)) != 0) {
          rest.append(s.charAt(i));
        } else {
          crossed.add(s.charAt(i));
        }
      }
      Collections.sort(crossed);

      if (rest.charAt(0) != '0') {
        int reducedD = Integer.parseInt(rest.toString());
        for (int reducedN = 1; reducedN < reducedD; ++reducedN) {
          if ((long) reducedN * D % reducedD == 0) {
            int N = (int) ((long) reducedN * D / reducedD);
            List<Character> diff = computeDiff(N, reducedN);
            if (diff != null && diff.equals(crossed)) {
              return N;
            }
          }
        }
      }
    }

    return -1;
  }

  List<Character> computeDiff(int N, int reducedN) {
    String strN = String.valueOf(N);
    String strReducedN = String.valueOf(reducedN);

    List<Character> diff = new ArrayList<>();
    int beginIndex = 0;
    for (char ch : strReducedN.toCharArray()) {
      int index = strN.indexOf(ch, beginIndex);
      if (index == -1) {
        return null;
      }

      for (int i = beginIndex; i < index; ++i) {
        diff.add(strN.charAt(i));
      }

      beginIndex = index + 1;
    }
    for (int i = beginIndex; i < strN.length(); ++i) {
      diff.add(strN.charAt(i));
    }

    Collections.sort(diff);

    return diff;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, int p1) {
    System.out.print("Test " + testNum + ": [" + p0);
    System.out.println("]");
    IncorrectCancellation obj;
    int answer;
    obj = new IncorrectCancellation();
    long startTime = System.currentTimeMillis();
    answer = obj.find(p0);
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

    int p0;
    int p1;

    // ----- test 0 -----
    p0 = 64;
    p1 = 16;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 98;
    p1 = 49;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 470;
    p1 = 10;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 1057;
    p1 = -1;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 15436;
    p1 = 454;
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = 15425;
    p1 = 13574;
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = 6665;
    p1 = 2666;
    all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
    // ------------------

    // ----- test 7 -----
    p0 = 1221;
    p1 = 222;
    all_right = KawigiEdit_RunTest(7, p0, true, p1) && all_right;
    // ------------------

    // ----- test 8 -----
    p0 = 7;
    p1 = -1;
    all_right = KawigiEdit_RunTest(8, p0, true, p1) && all_right;
    // ------------------

    // ----- test 9 -----
    p0 = 1285;
    p1 = -1;
    all_right = KawigiEdit_RunTest(9, p0, true, p1) && all_right;
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
