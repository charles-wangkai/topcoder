import java.util.stream.IntStream;

public class grafixCorrupt {
  public int selectWord(String[] dictionary, String candidate) {
    int result = -1;
    int maxSameCount = 0;
    for (int i = 0; i < dictionary.length; ++i) {
      int i_ = i;
      int sameCount =
          (int)
              IntStream.range(0, candidate.length())
                  .filter(j -> candidate.charAt(j) == dictionary[i_].charAt(j))
                  .count();
      if (sameCount > maxSameCount) {
        maxSameCount = sameCount;
        result = i;
      }
    }

    return result;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, String p1, boolean hasAnswer, int p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}" + "," + "\"" + p1 + "\"");
    System.out.println("]");
    grafixCorrupt obj;
    int answer;
    obj = new grafixCorrupt();
    long startTime = System.currentTimeMillis();
    answer = obj.selectWord(p0, p1);
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
    String p1;
    int p2;

    // ----- test 0 -----
    p0 = new String[] {"cat", "cab", "lab"};
    p1 = "dab";
    p2 = 1;
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"cat", "cab", "lab"};
    p1 = "lag";
    p2 = 2;
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"cat", "cab", "lab"};
    p1 = "bic";
    p2 = -1;
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 =
        new String[] {
          "zkv", "izs", "fed", "waa", "ttx", "bgt", "quy", "dtq", "dgo", "yrs", "cid", "nln", "pvz",
          "txt", "zun", "erd", "jen", "klh", "kxy", "emf", "mqt", "lza", "dzb", "ndx", "vfr", "jhs",
          "dkm", "elb"
        };
    p1 = "cwd";
    p2 = 10;
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 =
        new String[] {
          "zhadjsg", "vzptftx", "fbaslxs", "ejejncm", "xpxkeae", "ixrrtzw", "ovctbzx", "sfzekhh",
          "lxzixjk", "jixdpik", "bkianck", "laclyin", "uqmdkfx", "dimswqo", "fojhetr", "grntrce",
          "obdtqwx", "bhojwcy", "zuuuvst", "mvqtoly", "aftmupx", "govuidx", "qklpret", "yptccki",
          "uxdnslh", "wudrusz", "uwxbvou", "ouytqun", "pjdexqe", "xraaqdw", "lxmoncl", "sjnjfgb",
          "qrlqgvc", "fgvoadm", "yohsrxw", "udpvrsr", "mklucgt"
        };
    p1 = "vklikgf";
    p2 = 36;
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
