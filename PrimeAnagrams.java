import java.util.Arrays;

public class PrimeAnagrams {
  int[] solution;

  public int[] primes(String anagram) {
    int[] digits = anagram.chars().map(c -> c - '0').toArray();

    solution = new int[0];
    search(digits, 0);

    return solution;
  }

  void search(int[] digits, int index) {
    if (index == digits.length) {
      cut(digits, new int[3], 0, 0, 1);

      return;
    }

    for (int i = index; i < digits.length; ++i) {
      swap(digits, i, index);
      search(digits, index + 1);
      swap(digits, i, index);
    }
  }

  void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  void cut(int[] digits, int[] primes, int primeIndex, int digitIndex, int prevLength) {
    if (primeIndex == primes.length) {
      if (solution.length == 0 || computeProduct(primes) < computeProduct(solution)) {
        solution = Arrays.stream(primes).sorted().toArray();
      }

      return;
    }

    if (digits[digitIndex] != 0) {
      int minLength;
      int maxLength;
      if (primeIndex == primes.length - 1) {
        minLength = digits.length - digitIndex;
        maxLength = digits.length - digitIndex;
      } else {
        minLength = prevLength;
        maxLength = (digits.length - digitIndex) / 2;
      }

      for (int length = minLength; length <= maxLength; ++length) {
        int value = 0;
        for (int i = digitIndex; i < digitIndex + length; ++i) {
          value = value * 10 + digits[i];
        }

        if (isPrime(value)) {
          primes[primeIndex] = value;

          cut(digits, primes, primeIndex + 1, digitIndex + length, length);
        }
      }
    }
  }

  boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }

    for (int i = 2; i * i <= n; ++i) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

  long computeProduct(int[] a) {
    return Arrays.stream(a).asLongStream().reduce((acc, x) -> acc * x).getAsLong();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int[] p1) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
    System.out.println("]");
    PrimeAnagrams obj;
    int[] answer;
    obj = new PrimeAnagrams();
    long startTime = System.currentTimeMillis();
    answer = obj.primes(p0);
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

    String p0;
    int[] p1;

    // ----- test 0 -----
    p0 = "39151";
    p1 = new int[] {5, 13, 19};
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "921179";
    p1 = new int[] {2, 17, 199};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "01123";
    p1 = new int[] {2, 3, 101};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "0707070";
    p1 = new int[] {};
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "222";
    p1 = new int[] {2, 2, 2};
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = "123";
    p1 = new int[] {};
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = "850793";
    p1 = new int[] {5, 7, 3089};
    all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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
