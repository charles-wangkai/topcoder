import java.util.stream.IntStream;

public class NoisySensor {
  public int[] medianFilter(int[] data) {
    return IntStream.range(0, data.length)
        .map(
            i ->
                (i == 0 || i == data.length - 1)
                    ? data[i]
                    : computeMedian(data[i - 1], data[i], data[i + 1]))
        .toArray();
  }

  int computeMedian(int a, int b, int c) {
    return IntStream.of(a, b, c).sorted().skip(1).findFirst().getAsInt();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int[] p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}");
    System.out.println("]");
    NoisySensor obj;
    int[] answer;
    obj = new NoisySensor();
    long startTime = System.currentTimeMillis();
    answer = obj.medianFilter(p0);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p1.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print(p1[i]);
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
      if (answer.length != p1.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (answer[i] != p1[i]) {
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

    // ----- test 0 -----
    p0 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    p1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {10, 1, 9, 2, 8};
    p1 = new int[] {10, 9, 2, 8, 8};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {500, 500, 500, 500, 500};
    p1 = new int[] {500, 500, 500, 500, 500};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {-2147483648, 2147483647};
    p1 = new int[] {-2147483648, 2147483647};
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 =
        new int[] {
          432296535,
          1983848899,
          -434724194,
          135703525,
          -1146336142,
          -680568092,
          -1183352724,
          1337550909,
          -1597342716,
          -1901441857,
          1726722019,
          -558651015,
          649930787,
          1889036519,
          1752815826,
          930647381,
          -852547667,
          2028345278,
          -1835531493,
          -1040566300,
          -1566043783,
          -1282411107,
          -1123988603,
          2132078516,
          -1169614369,
          -523503536,
          1466102514,
          -2003903121,
          -779001645,
          1919742042,
          1210980485,
          -9273881,
          1033032137,
          -1474003783,
          296280591,
          920184999,
          -1235054743,
          -1329769514,
          -1727085135
        };
    p1 =
        new int[] {
          432296535,
          432296535,
          135703525,
          -434724194,
          -680568092,
          -1146336142,
          -680568092,
          -1183352724,
          -1597342716,
          -1597342716,
          -558651015,
          649930787,
          649930787,
          1752815826,
          1752815826,
          930647381,
          930647381,
          -852547667,
          -1040566300,
          -1566043783,
          -1282411107,
          -1282411107,
          -1123988603,
          -1123988603,
          -523503536,
          -523503536,
          -523503536,
          -779001645,
          -779001645,
          1210980485,
          1210980485,
          1033032137,
          -9273881,
          296280591,
          296280591,
          296280591,
          -1235054743,
          -1329769514,
          -1727085135
        };
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
