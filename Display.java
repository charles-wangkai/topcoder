import java.util.Arrays;
import java.util.stream.IntStream;

public class Display {
  public String[] transform(int[] x, int[] y) {
    int minX = Arrays.stream(x).min().getAsInt();
    int maxX = Arrays.stream(x).max().getAsInt();
    int minY = Arrays.stream(y).min().getAsInt();
    int maxY = Arrays.stream(y).max().getAsInt();

    return IntStream.range(0, x.length)
        .mapToObj(i -> String.format("%d %d", convert(minX, maxX, x[i]), convert(minY, maxY, y[i])))
        .toArray(String[]::new);
  }

  static int convert(int min, int max, int value) {
    return (int) (((value - min) * 10000L + 5L * (max - min)) / (10L * (max - min)));
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int[] p0, int[] p1, boolean hasAnswer, String[] p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p1.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p1[i]);
    }
    System.out.print("}");
    System.out.println("]");
    Display obj;
    String[] answer;
    obj = new Display();
    long startTime = System.currentTimeMillis();
    answer = obj.transform(p0, p1);
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
        System.out.print("\"" + p2[i] + "\"");
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + answer[i] + "\"");
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p2.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (!answer[i].equals(p2[i])) {
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

    int[] p0;
    int[] p1;
    String[] p2;

    // ----- test 0 -----
    p0 = new int[] {-100, 0, 50, 100};
    p1 = new int[] {-100, 0, 50, 100};
    p2 = new String[] {"0 0", "500 500", "750 750", "1000 1000"};
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {0, 2000, 1};
    p1 = new int[] {0, 2001, 1};
    p2 = new String[] {"0 0", "1000 1000", "1 0"};
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {-1000000000, 1000000000, 500000, 499999};
    p1 = new int[] {-1000000000, 1000000000, 500000, 499999};
    p2 = new String[] {"0 0", "1000 1000", "500 500", "500 500"};
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {-53, 652, -6132, 673, 74, -473, 373, 736363, 234, 234, 234};
    p1 = new int[] {-6464, 36464, -43, 373, 363, -37633, 2022, -644, 2520, 2520, 2520};
    p2 =
        new String[] {
          "8 421",
          "9 1000",
          "0 507",
          "9 513",
          "8 513",
          "8 0",
          "9 535",
          "1000 499",
          "9 542",
          "9 542",
          "9 542"
        };
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new int[] {0, 1001, 2000};
    p1 = new int[] {0, 999, 2000};
    p2 = new String[] {"0 0", "501 500", "1000 1000"};
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
