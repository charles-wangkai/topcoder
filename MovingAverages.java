import java.util.stream.IntStream;

public class MovingAverages {
  public int[] calculate(String[] times, int n) {
    int[] result = new int[times.length - n + 1];
    int sum = IntStream.range(0, n - 1).map(i -> convertToSecond(times[i])).sum();
    for (int i = 0; i < result.length; ++i) {
      sum += convertToSecond(times[i + n - 1]);
      result[i] = sum / n;

      sum -= convertToSecond(times[i]);
    }

    return result;
  }

  int convertToSecond(String time) {
    String[] parts = time.split(":");

    return Integer.parseInt(parts[0]) * 60 * 60
        + Integer.parseInt(parts[1]) * 60
        + Integer.parseInt(parts[2]);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, int p1, boolean hasAnswer, int[] p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}" + "," + p1);
    System.out.println("]");
    MovingAverages obj;
    int[] answer;
    obj = new MovingAverages();
    long startTime = System.currentTimeMillis();
    answer = obj.calculate(p0, p1);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p2.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print(p2[i]);
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(answer[i]);
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p2.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (answer[i] != p2[i]) {
            res = false;
          }
        }
      }
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
    int[] p2;

    // ----- test 0 -----
    p0 = new String[] {"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
    p1 = 3;
    p2 = new int[] {4731, 4695, 4684};
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
    p1 = 1;
    p2 = new int[] {4750, 4660, 4784, 4643, 4627};
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
    p1 = 5;
    p2 = new int[] {4692};
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