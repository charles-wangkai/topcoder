import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class bloggoHyphenate {
  public String[] correct(String[] dictionary, String[] candidates) {
    Map<String, Set<Integer>> wordToLengths = new HashMap<>();
    for (String d : dictionary) {
      String word = d.replace(" ", "");

      Set<Integer> lengths = new HashSet<>();
      int length = 0;
      for (int i = 0; i < d.length(); ++i) {
        if (d.charAt(i) == ' ') {
          lengths.add(length);
        } else {
          ++length;
        }
      }

      wordToLengths.put(word, lengths);
    }

    return Arrays.stream(candidates)
        .map(candidate -> correctOne(wordToLengths, candidate))
        .toArray(String[]::new);
  }

  String correctOne(Map<String, Set<Integer>> wordToLengths, String candidate) {
    String word = candidate.replace("-", "");
    int length = candidate.indexOf('-');

    Set<Integer> lengths = wordToLengths.get(word);
    if (lengths.contains(length)) {
      return "correct";
    }

    if (lengths.isEmpty()) {
      return word;
    }

    int minDiff = Integer.MAX_VALUE;
    int correctedLength = -1;
    for (int l : lengths) {
      int diff = Math.abs(l - length);
      if (diff < minDiff || (diff == minDiff && l < correctedLength)) {
        minDiff = diff;
        correctedLength = l;
      }
    }

    return String.format(
        "%s-%s", word.substring(0, correctedLength), word.substring(correctedLength));
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, String[] p1, boolean hasAnswer, String[] p2) {
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
    bloggoHyphenate obj;
    String[] answer;
    obj = new bloggoHyphenate();
    long startTime = System.currentTimeMillis();
    answer = obj.correct(p0, p1);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p2.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print("\"" + p2[i] + "\"");
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + answer[i] + "\"");
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p2.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (!answer[i].equals(p2[i])) {
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
    String[] p1;
    String[] p2;

    // ----- test 0 -----
    p0 = new String[] {"syl la ble", "dic tion a ry", "mole"};
    p1 = new String[] {"mo-le", "syl-lable"};
    p2 = new String[] {"mole", "correct"};
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"syl la ble", "dic tion a ry", "mole"};
    p1 = new String[] {"dictio-nary", "syll-able"};
    p2 = new String[] {"diction-ary", "syl-lable"};
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"syl la ble", "dic tion a ry", "mole"};
    p1 = new String[] {"dictionary-", "-syllable"};
    p2 = new String[] {"dictiona-ry", "syl-lable"};
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 =
        new String[] {
          "zsx kd ds jply rf",
          "auca wb ill",
          "kvqm kpd p kqi xpbk j",
          "cqf ccr ewq",
          "srl vu m u d b",
          "h qae qzge",
          "jdn qqjf y",
          "zpa hbr",
          "d uft ctsm qjg",
          "l hgcp ik twuy bsi nlmu iyx",
          "cjjz jn td zg",
          "h bd q hi",
          "obsr kci hjdm h yar zsq q xyr hxb",
          "izq iibd yuh tgx nkq",
          "cjgd wfns",
          "ohc bn duc",
          "pydv a geki s bo avdi wd",
          "zygp gqt p",
          "xq pqqb ufoe",
          "cvm yamq moqj vl zoig w",
          "ahz b lf ixjv d",
          "qpg ven d",
          "m cbxz yf tv djf",
          "kti wacd uvgb kmr ew r",
          "ng tfb unw ndl",
          "qruv ctw a",
          "d hk v pcxh zoxy",
          "etbo wabk",
          "x hxiu n",
          "wp qq u dvpi tclh ac l",
          "f am brs lk uss uyb pg",
          "dtfx h ict if koe jhj",
          "nl shp yeji b rw vrg",
          "bz qfnc u",
          "t ceoy eb ss myoe zaaj z jey",
          "j d uju mb irvu",
          "anmo emjs syam ta bfiy kk",
          "gl ej egla tha jbug",
          "zk u sz raij d",
          "kw lbya atdb pd",
          "no id hqum u wny qcy",
          "phv nv l f oq m",
          "b xup tnq fziw yth sn",
          "pvc hnr oky lzj",
          "ew wtwt gyty s uu pfe kif my",
          "t cw fsau",
          "esk gqtd o yh jbx wed fl z",
          "vvr hqw wo gxwm",
          "lei akz nzz bumb",
          "bc hlmw"
        };
    p1 =
        new String[] {
          "-duftctsmqjg",
          "-leiakznzzbumb",
          "-xhxiun",
          "-zpahbr",
          "ahzbl-fixjvd",
          "anmo-emjssyamtabfiykk",
          "aucawb-ill",
          "bchlmw-",
          "bxuptnqfziwyth-sn",
          "bzq-fncu",
          "c-vmyamqmoqjvlzoigw",
          "cjg-dwfns",
          "cjjzjn-tdzg",
          "cqfccre-wq",
          "dhkvpcxhzox-y",
          "dtfx-hictifkoejhj",
          "eskgqtdoyhjbx-wedflz",
          "etbowab-k",
          "ewwtwtgytysuupfe-kifmy",
          "fambrslkuss-uybpg",
          "glejegl-athajbug",
          "hbdqhi-",
          "hq-aeqzge",
          "izqiibd-yuhtgxnkq",
          "jd-nqqjfy",
          "jdujumb-irvu",
          "ktiwacduvgbkmr-ewr",
          "kv-qmkpdpkqixpbkj",
          "kwlbya-atdbpd",
          "lhgcpiktwuybsi-nlmuiyx",
          "mcbx-zyftvdjf",
          "ngtf-bunwndl",
          "nlshpyejibrwvrg-",
          "no-idhqumuwnyqcy",
          "o-hcbnduc",
          "obsr-kcihjdmhyarzsqqxyrhxb",
          "ph-vnvlfoqm",
          "pvchnrok-ylzj",
          "pydvageki-sboavdiwd",
          "qpgv-end",
          "qruvctw-a",
          "srlvumu-db",
          "tceoyebssmyo-ezaajzjey",
          "tcwfsau-",
          "vvrhqwwo-gxwm",
          "wpqqudvpit-clhacl",
          "xqpq-qbufoe",
          "zku-szraijd",
          "zsxkddsjp-lyrf",
          "zygpgqt-p"
        };
    p2 =
        new String[] {
          "d-uftctsmqjg",
          "lei-akznzzbumb",
          "x-hxiun",
          "zpa-hbr",
          "ahzb-lfixjvd",
          "correct",
          "correct",
          "bc-hlmw",
          "correct",
          "bz-qfncu",
          "cvm-yamqmoqjvlzoigw",
          "cjgd-wfns",
          "correct",
          "cqfccr-ewq",
          "dhkvpcxh-zoxy",
          "correct",
          "correct",
          "etbo-wabk",
          "correct",
          "correct",
          "glejegla-thajbug",
          "hbdq-hi",
          "h-qaeqzge",
          "correct",
          "jdn-qqjfy",
          "correct",
          "correct",
          "kvqm-kpdpkqixpbkj",
          "correct",
          "correct",
          "mcbxz-yftvdjf",
          "ngtfb-unwndl",
          "nlshpyejibrw-vrg",
          "correct",
          "ohc-bnduc",
          "correct",
          "phv-nvlfoqm",
          "pvchnroky-lzj",
          "correct",
          "qpg-vend",
          "correct",
          "correct",
          "tceoyebssmyoe-zaajzjey",
          "tcw-fsau",
          "correct",
          "wpqqudvpi-tclhacl",
          "xq-pqqbufoe",
          "correct",
          "zsxkdds-jplyrf",
          "correct"
        };
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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
