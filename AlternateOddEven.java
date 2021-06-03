public class AlternateOddEven {
  public long kth(long K) {
    long result = -1;
    long lower = 1;
    long upper = Long.MAX_VALUE;
    while (lower <= upper) {
      long middle = lower + (upper - lower) / 2;
      if (computeLessEqualNum(middle) >= K) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  long computeLessEqualNum(long x) {
    if (x <= 9) {
      return x;
    }

    long result = 0;
    String s = String.valueOf(x);
    for (int i = 1; i < s.length(); ++i) {
      result += 9 * pow5(i - 1);
    }

    int[] digits = new int[s.length()];
    for (int i = 0; i < digits.length; ++i) {
      digits[i] = s.charAt(i) - '0';
    }

    for (int i = 1; i < digits[0]; ++i) {
      result += pow5(s.length() - 1);
    }

    for (int i = 1; i < s.length(); ++i) {
      if (digits[i] % 2 == digits[i - 1] % 2) {
        result += (digits[i] + 1) / 2 * pow5(s.length() - i - 1);

        break;
      } else {
        result += digits[i] / 2 * pow5(s.length() - i - 1);

        if (i == s.length() - 1) {
          ++result;
        }
      }
    }

    return result;
  }

  long pow5(int exponent) {
    long result = 1;
    for (int i = 0; i < exponent; ++i) {
      result *= 5;
    }

    return result;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, long p0, boolean hasAnswer, long p1) {
    System.out.print("Test " + testNum + ": [" + p0);
    System.out.println("]");
    AlternateOddEven obj;
    long answer;
    obj = new AlternateOddEven();
    long startTime = System.currentTimeMillis();
    answer = obj.kth(p0);
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

    long p0;
    long p1;

    // ----- test 0 -----
    p0 = 9L;
    p1 = 9L;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 15L;
    p1 = 21L;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 62L;
    p1 = 125L;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 100L;
    p1 = 290L;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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