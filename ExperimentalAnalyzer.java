import java.util.Arrays;
import java.util.stream.IntStream;

public class ExperimentalAnalyzer {
  public int[] getPredictors(String[] data) {
    if (Arrays.stream(data).allMatch(x -> x.startsWith("0"))
        || Arrays.stream(data).allMatch(x -> x.startsWith("1"))) {
      return new int[0];
    }

    int variableNum = data[0].split(" ").length - 1;

    int[][] mins = new int[2][variableNum];
    int[][] maxs = new int[2][variableNum];
    for (int i = 0; i < 2; ++i) {
      Arrays.fill(mins[i], Integer.MAX_VALUE);
      Arrays.fill(maxs[i], Integer.MIN_VALUE);
    }

    for (String e : data) {
      int[] parts = Arrays.stream(e.split(" ")).mapToInt(Integer::parseInt).toArray();
      int outcome = parts[0];

      for (int i = 0; i < variableNum; ++i) {
        mins[outcome][i] = Math.min(mins[outcome][i], parts[i + 1]);
        maxs[outcome][i] = Math.max(maxs[outcome][i], parts[i + 1]);
      }
    }

    return IntStream.range(0, variableNum)
        .filter(i -> maxs[0][i] < mins[1][i] || maxs[1][i] < mins[0][i])
        .map(i -> i + 1)
        .toArray();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int[] p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    ExperimentalAnalyzer obj;
    int[] answer;
    obj = new ExperimentalAnalyzer();
    long startTime = System.currentTimeMillis();
    answer = obj.getPredictors(p0);
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

    String[] p0;
    int[] p1;

    // ----- test 0 -----
    p0 = new String[] {"0 10 20 20 0", "1 20 30 17 98765", "0 10 30 29 1234567", "1 20 40 10 42"};
    p1 = new int[] {1, 3};
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 =
        new String[] {
          "1 220 212 247 764 928 956 946 66 640 983 125 994",
          "0 816 835 98 81 783 267 946 584 309 757 876 670"
        };
    p1 = new int[] {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 =
        new String[] {
          "0 1944914038 1696137778 1525367830",
          "0 1547932733 1185820653 1500052399",
          "0 230149443 1358715189 501418065",
          "0 1676118083 1499656529 2103271593",
          "0 1441540020 1189300515 1544659186"
        };
    p1 = new int[] {};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 =
        new String[] {
          "0 163869663 388719849 383049741",
          "1 1982032201 1346175990 1500891700",
          "0 436834674 559375803 994453722",
          "0 652316051 372955428 361692727",
          "1 1946362869 1204080206 2066121600",
          "0 840867095 22073435 1166658385",
          "1 1864235269 2041251772 1847305529",
          "0 852306016 447986701 407997336",
          "1 1183214776 728141214 1985649244",
          "0 70064437 7110416 107908753",
          "1 1383409284 1328770197 1942831571",
          "1 1023334064 1596272317 1226876467",
          "1 2068895243 1481323649 1955807390",
          "0 758836687 541737411 312747384",
          "1 1432983907 1475284843 1512945413",
          "1 1512506825 1933755150 2041997368",
          "1 2041700103 1859742986 1995865005",
          "0 323696628 328891715 893352493",
          "1 1623710967 1193592990 1871502957",
          "0 9241593 127579695 36337622",
          "1 1935123182 1332735215 1400991717",
          "1 2130762600 1874898210 1234793873",
          "0 411777048 142083649 61450530",
          "1 1042383468 1979605937 1276643901",
          "0 219279208 371281702 65383690",
          "0 948808405 243728462 984221323",
          "0 999393888 131231007 1186873391",
          "1 1294115986 1618148416 1324126407",
          "1 171081184" + "2 2024808989 1696767048",
          "1 1399327255 1317859960 1427366434",
          "0 145887863 452552798 165691442",
          "0 685701683 334764463 1001631935",
          "1 1596433536 1911594193 1533322508",
          "0 128647261 372955025 1051296077",
          "0 946946329 548039713 83591687",
          "1 1490995704 1541151932 2052868342",
          "0 805037508 405134691 593191395",
          "1 2048614262 1171142414 1309623012",
          "1 1024870244 1791074791 1778846631",
          "1 1403452711 2033486235 1555085078",
          "0 900806815 269954427 806033528",
          "1 1598931622 938905156 1474311731",
          "1 1468418323 749319445 2060324871",
          "0 407246582 393808982 163347811",
          "0 52629967 643176802 619367349"
        };
    p1 = new int[] {1, 2, 3};
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
