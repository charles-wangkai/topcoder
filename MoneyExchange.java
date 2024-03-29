import java.util.HashMap;
import java.util.Map;

public class MoneyExchange {
  static final double EPSILON = 1e-9;

  public double bestRate(String[] rates, String type1, String type2) {
    if (type1.equals(type2)) {
      return 1;
    }

    Map<String, Integer> typeToIndex = new HashMap<>();
    typeToIndex.put(type1, 0);
    typeToIndex.put(type2, 1);
    for (String rate : rates) {
      String[] parts = rate.split(" ");

      typeToIndex.putIfAbsent(parts[0], typeToIndex.size());
      typeToIndex.putIfAbsent(parts[2], typeToIndex.size());
    }

    int typeNum = typeToIndex.size();
    double[][] maxRates = new double[typeNum][typeNum];
    for (int i = 0; i < typeNum; ++i) {
      for (int j = 0; j < typeNum; ++j) {
        maxRates[i][j] = (i == j) ? 1 : -1;
      }
    }

    for (String rate : rates) {
      String[] parts = rate.split(" ");

      int typeIndex1 = typeToIndex.get(parts[0]);
      int num1 = Integer.parseInt(parts[1]);
      int typeIndex2 = typeToIndex.get(parts[2]);
      int num2 = Integer.parseInt(parts[3]);

      maxRates[typeIndex1][typeIndex2] =
          Math.max(maxRates[typeIndex1][typeIndex2], (double) num2 / num1);
    }

    for (int k = 0; k < typeNum; ++k) {
      for (int i = 0; i < typeNum; ++i) {
        for (int j = 0; j < typeNum; ++j) {
          if (maxRates[i][k] >= -EPSILON && maxRates[k][j] >= -EPSILON) {
            maxRates[i][j] = Math.max(maxRates[i][j], maxRates[i][k] * maxRates[k][j]);
          }
        }
      }
    }

    return maxRates[0][1];
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, String p1, String p2, boolean hasAnswer, double p3) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}" + "," + "\"" + p1 + "\"" + "," + "\"" + p2 + "\"");
    System.out.println("]");
    MoneyExchange obj;
    double answer;
    obj = new MoneyExchange();
    long startTime = System.currentTimeMillis();
    answer = obj.bestRate(p0, p1, p2);
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
      res = Math.abs(p3 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p3));
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
    String p2;
    double p3;

    // ----- test 0 -----
    p0 = new String[] {"EUR 8 USD 10", "USD 10 EUR 7"};
    p1 = "EUR";
    p2 = "USD";
    p3 = 1.25D;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"EUR 0008 USD 0010"};
    p1 = "USD";
    p2 = "EUR";
    p3 = -1.0D;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"EUR 8 USD 10", "EUR 1 GOODBUY 2", "GOODBUY 1 USD 2"};
    p1 = "EUR";
    p2 = "USD";
    p3 = 4.0D;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new String[] {"A 1 B 2", "A 1 C 3", "B 2 D 3", "C 9 D 10", "D 7 E 2"};
    p1 = "A";
    p2 = "E";
    p3 = 0.9523809523809523D;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new String[] {};
    p1 = "TYPEA";
    p2 = "TYPEB";
    p3 = -1.0D;
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = new String[] {"A 7 A 5", "A 1 B 1", "B 2 A 2"};
    p1 = "A";
    p2 = "A";
    p3 = 1.0D;
    all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 =
        new String[] {
          "KOWA 9 MJ 1",
          "LSW 2 CFEKD 6",
          "QJDKHKE 1 COT 2",
          "OZWM 5 QJDKHKE 5",
          "BWCJ 10 DWO 10",
          "YF 9 FVQYAX 9",
          "XZIH 7 RQN 2",
          "PQL 5 DFOXFQ 10",
          "ZDC 1 BWCJ 3",
          "YF 8 IJGUTK 2",
          "JV 8 WR 10",
          "ZY 6 NTDYLR 4",
          "IF 8 OJJYDOL 8",
          "YLDNBMAE 1 SURPI 6",
          "OCMAMK 5 PRLUWK 7",
          "IJGUTK 7 WMVQQ 9",
          "LYFUJ 5 ISAC 9",
          "KKH 4 IF 2",
          "IF 7 LUR 4",
          "PAUFQ 10 YNOX 3",
          "JV 9 OKHH 9",
          "NAMGWIW 9 VPI 1",
          "FVQYAX 3 IJGUTK 5",
          "JMUB 6 RQN 2",
          "YEIKM 10 GC 10",
          "PEMBLGKY 2 LS 6",
          "UTBVO 3 LS 8",
          "HGH 9 DWO 5",
          "XZIH 9 PEP 9",
          "OZWM 6 XZIH 9",
          "RQN 4 PRLUWK 10",
          "LUR 5 DWO 9",
          "RVV 8 IF 7",
          "FDB 10 PQL 9",
          "JTDSZD 10 WJUC 5",
          "CLIL 2 KEAG 10",
          "LYFUJ 4 WCDK 1",
          "KVIR 9 BXGZ 1",
          "MJ 4 QJBSW 3",
          "YF 7 FVQYAX 1",
          "EAFTXCS 9 QJDKHKE 4",
          "YH 5 DWO 10",
          "AD 10 RVV 4",
          "BXGZ 7 PAUFQ 2",
          "WCDK 3 HGH 2",
          "KZIU 9 IJGUTK 1",
          "IVZXQ 5 IF 3",
          "EAFTXCS 4 QJBSW 1",
          "OZWM 4 COT 2",
          "ZDC 2 IVZXQ 8"
        };
    p1 = "KOWA";
    p2 = "IVZXQ";
    p3 = -1.0D;
    all_right = KawigiEdit_RunTest(6, p0, p1, p2, true, p3) && all_right;
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
