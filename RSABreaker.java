import java.math.BigInteger;
import java.util.stream.IntStream;

public class RSABreaker {
  public int decrypt(int e, int n, int b) {
    int m = (int) IntStream.range(1, n).filter(x -> gcd(x, n) == 1).count();
    int d = IntStream.range(0, m).filter(x -> e * x % m == 1).findAny().getAsInt();

    return BigInteger.valueOf(b).modPow(BigInteger.valueOf(d), BigInteger.valueOf(n)).intValue();
  }

  int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, int p2, boolean hasAnswer, int p3) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
    System.out.println("]");
    RSABreaker obj;
    int answer;
    obj = new RSABreaker();
    long startTime = System.currentTimeMillis();
    answer = obj.decrypt(p0, p1, p2);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p3);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p3;
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
    int p3;

    // ----- test 0 -----
    p0 = 3;
    p1 = 10;
    p2 = 3;
    p3 = 7;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 17;
    p1 = 33;
    p2 = 4;
    p3 = 31;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 1;
    p1 = 42;
    p2 = 17;
    p3 = 17;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 5;
    p1 = 997;
    p2 = 7;
    p3 = 523;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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
