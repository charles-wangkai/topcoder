import java.util.Arrays;

public class ArraySorting {
  public int[] arraySort(int[] A) {
    int[] lengths = new int[A.length];
    for (int i = lengths.length - 1; i >= 0; --i) {
      lengths[i] = 1;
      for (int j = i + 1; j < lengths.length; ++j) {
        if (A[i] <= A[j]) {
          lengths[i] = Math.max(lengths[i], lengths[j] + 1);
        }
      }
    }

    int[] result = new int[A.length];
    int maxLength = Arrays.stream(lengths).max().getAsInt();
    int lower = 0;
    for (int i = maxLength; i >= 1; --i) {
      int index = findLast(A, lengths, i, lower);

      result[index] = A[index];
      lower = result[index];
    }

    int prev = 1;
    for (int i = 0; i < result.length; ++i) {
      if (result[i] == 0) {
        result[i] = prev;
      }

      prev = result[i];
    }

    return result;
  }

  int findLast(int[] A, int[] lengths, int targetLength, int lower) {
    for (int i = A.length - 1; ; --i) {
      if (lengths[i] == targetLength && A[i] >= lower) {
        return i;
      }
    }
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
    ArraySorting obj;
    int[] answer;
    obj = new ArraySorting();
    long startTime = System.currentTimeMillis();
    answer = obj.arraySort(p0);
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
    p0 = new int[] {10, 8};
    p1 = new int[] {1, 8};
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {6, 9};
    p1 = new int[] {6, 9};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {9, 8, 10, 4};
    p1 = new int[] {1, 8, 10, 10};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {3, 7, 7, 7, 6};
    p1 = new int[] {3, 7, 7, 7, 7};
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
