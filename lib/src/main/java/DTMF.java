import static java.util.Map.entry;

import java.util.Map;

public class DTMF {
  static final Map<String, Character> PAIR_TO_CHAR =
      Map.ofEntries(
          entry("L1,H1", '1'),
          entry("H1,L1", '1'),
          entry("L1,H2", '2'),
          entry("H2,L1", '2'),
          entry("L1,H3", '3'),
          entry("H3,L1", '3'),
          entry("L2,H1", '4'),
          entry("H1,L2", '4'),
          entry("L2,H2", '5'),
          entry("H2,L2", '5'),
          entry("L2,H3", '6'),
          entry("H3,L2", '6'),
          entry("L3,H1", '7'),
          entry("H1,L3", '7'),
          entry("L3,H2", '8'),
          entry("H2,L3", '8'),
          entry("L3,H3", '9'),
          entry("H3,L3", '9'),
          entry("L4,H1", '*'),
          entry("H1,L4", '*'),
          entry("L4,H2", '0'),
          entry("H2,L4", '0'),
          entry("L4,H3", '#'),
          entry("H3,L4", '#'));

  public String decode(String[] frequencies) {
    StringBuilder result = new StringBuilder();
    for (String f : frequencies) {
      if (!PAIR_TO_CHAR.containsKey(f)) {
        return "error";
      }

      result.append(PAIR_TO_CHAR.get(f));
    }

    return result.toString();
  }
}
