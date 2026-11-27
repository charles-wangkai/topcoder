import static java.util.Map.entry;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MorseEnc {
  static final Map<Character, String> CHAR_TO_MORSE =
      Map.ofEntries(
          entry('A', ".-"),
          entry('B', "-..."),
          entry('C', "-.-."),
          entry('D', "-.."),
          entry('E', "."),
          entry('F', "..-."),
          entry('G', "--."),
          entry('H', "...."),
          entry('I', ".."),
          entry('J', ".---"),
          entry('K', "-.-"),
          entry('L', ".-.."),
          entry('M', "--"),
          entry('N', "-."),
          entry('O', "---"),
          entry('P', ".--."),
          entry('Q', "--.-"),
          entry('R', ".-."),
          entry('S', "..."),
          entry('T', "-"),
          entry('U', "..-"),
          entry('V', "...-"),
          entry('W', ".--"),
          entry('X', "-..-"),
          entry('Y', "-.--"),
          entry('Z', "--.."),
          entry('0', "-----"),
          entry('1', ".----"),
          entry('2', "..---"),
          entry('3', "...--"),
          entry('4', "....-"),
          entry('5', "....."),
          entry('6', "-...."),
          entry('7', "--..."),
          entry('8', "---.."),
          entry('9', "----."));

  public String encode(String message) {
    return Arrays.stream(message.toUpperCase().split(" "))
        .map(word ->
            word.chars()
                .mapToObj(c -> (char) c)
                .map(CHAR_TO_MORSE::get)
                .collect(Collectors.joining(" ")))
        .collect(Collectors.joining(" / "));
  }
}
