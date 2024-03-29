import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DeserializeSequence {
  public int howMany(String str) {
    @SuppressWarnings("unchecked")
    Map<Integer, Integer>[] wayNums = new Map[str.length() + 1];
    for (int i = 0; i < wayNums.length; ++i) {
      wayNums[i] = new HashMap<>();
    }
    wayNums[0].put(1, 1);

    for (int i = 1; i <= str.length(); ++i) {
      for (int j = 1; j <= i; ++j) {
        BigInteger current = new BigInteger(str.substring(i - j, i));
        if (current.compareTo(BigInteger.valueOf(1_000_000)) > 0) {
          break;
        }

        if (!current.equals(BigInteger.ZERO)) {
          for (int prev : wayNums[i - j].keySet()) {
            if (prev <= current.intValue()) {
              wayNums[i].put(
                  current.intValue(),
                  wayNums[i].getOrDefault(current.intValue(), 0) + wayNums[i - j].get(prev));
            }
          }
        }
      }
    }

    return wayNums[str.length()].values().stream().mapToInt(Integer::intValue).sum();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
    System.out.println("]");
    DeserializeSequence obj;
    int answer;
    obj = new DeserializeSequence();
    long startTime = System.currentTimeMillis();
    answer = obj.howMany(p0);
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

    String p0;
    int p1;

    // ----- test 0 -----
    p0 = "1234";
    p1 = 5;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "000000000001";
    p1 = 1;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "1000000000000";
    p1 = 0;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "9876543210";
    p1 = 5;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "11111111111111111111111111111111111111111111111111";
    p1 = 9192;
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = "10010010010010010010010010010010010010010010010010";
    p1 = 1217;
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
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
