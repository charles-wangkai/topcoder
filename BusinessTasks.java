import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessTasks {
  public String getTask(String[] list, int n) {
    List<String> rests = Arrays.stream(list).collect(Collectors.toList());
    int index = 0;
    while (rests.size() != 1) {
      index = (index + n - 1) % rests.size();
      rests.remove(index);
    }

    return rests.get(0);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, int p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}" + "," + p1);
    System.out.println("]");
    BusinessTasks obj;
    String answer;
    obj = new BusinessTasks();
    long startTime = System.currentTimeMillis();
    answer = obj.getTask(p0, p1);
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

    String[] p0;
    int p1;
    String p2;

    // ----- test 0 -----
    p0 = new String[] {"a", "b", "c", "d"};
    p1 = 2;
    p2 = "a";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"a", "b", "c", "d", "e"};
    p1 = 3;
    p2 = "d";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"alpha", "beta", "gamma", "delta", "epsilon"};
    p1 = 1;
    p2 = "epsilon";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new String[] {"a", "b"};
    p1 = 1000;
    p2 = "a";
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 =
        new String[] {
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
          "s", "t", "u", "v", "w", "x", "y", "z"
        };
    p1 = 17;
    p2 = "n";
    all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 =
        new String[] {
          "zlqamum",
          "yjsrpybmq",
          "tjllfea",
          "fxjqzznvg",
          "nvhekxr",
          "am",
          "skmazcey",
          "piklp",
          "olcqvhg",
          "dnpo",
          "bhcfc",
          "y",
          "h",
          "fj",
          "bjeoaxglt",
          "oafduixsz",
          "kmtbaxu",
          "qgcxjbfx",
          "my",
          "mlhy",
          "bt",
          "bo",
          "q"
        };
    p1 = 9000000;
    p2 = "fxjqzznvg";
    all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
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
