import java.util.Arrays;
import java.util.stream.IntStream;

public class VendingMachine {
  public int motorUse(String[] prices, String[] purchases) {
    int row = prices.length;
    int col = prices[0].split(" ").length;

    int[][] config = new int[row][col];
    for (int r = 0; r < row; ++r) {
      config[r] = Arrays.stream(prices[r].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    int result = 0;
    int currentCol = 0;
    int prevTime = -5;

    for (String purchase : purchases) {
      String parts[] = purchase.split("[,:]");
      int r = Integer.parseInt(parts[0]);
      int c = Integer.parseInt(parts[1]);
      int time = Integer.parseInt(parts[2]);

      if (time - prevTime >= 5) {
        int bestCol = findBestCol(config);
        result += move(col, currentCol, bestCol);
        currentCol = bestCol;
      }

      if (config[r][c] == 0) {
        return -1;
      }
      config[r][c] = 0;

      result += move(col, currentCol, c);
      currentCol = c;

      prevTime = time;
    }

    int bestCol = findBestCol(config);
    result += move(col, currentCol, bestCol);
    currentCol = bestCol;

    return result;
  }

  int findBestCol(int[][] config) {
    int result = -1;
    int bestSum = -1;
    for (int c = 0; c < config[0].length; ++c) {
      int c_ = c;
      int sum = IntStream.range(0, config.length).map(r -> config[r][c_]).sum();
      if (sum > bestSum) {
        result = c;
        bestSum = sum;
      }
    }

    return result;
  }

  int move(int col, int currentCol, int targetCol) {
    int diff = Math.abs(currentCol - targetCol);

    return Math.min(diff, col - diff);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, String[] p1, boolean hasAnswer, int p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p1.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p1[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    VendingMachine obj;
    int answer;
    obj = new VendingMachine();
    long startTime = System.currentTimeMillis();
    answer = obj.motorUse(p0, p1);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p2);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p2;
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
    String[] p1;
    int p2;

    // ----- test 0 -----
    p0 = new String[] {"100 100 100"};
    p1 = new String[] {"0,0:0", "0,2:5", "0,1:10"};
    p2 = 4;
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"100 200 300 400 500 600"};
    p1 = new String[] {"0,2:0", "0,3:5", "0,1:10", "0,4:15"};
    p2 = 17;
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"100 200 300 400 500 600"};
    p1 = new String[] {"0,2:0", "0,3:4", "0,1:8", "0,4:12"};
    p2 = 11;
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new String[] {"100 100 100"};
    p1 = new String[] {"0,0:10", "0,0:11"};
    p2 = -1;
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new String[] {"100 200 300", "600 500 400"};
    p1 = new String[] {"0,0:0", "1,1:10", "1,2:20", "0,1:21", "1,0:22", "0,2:35"};
    p2 = 6;
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
