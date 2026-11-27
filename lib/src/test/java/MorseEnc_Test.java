import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MorseEnc_Test {
  record Input(String message) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input("SOS"), new Output("... --- ...")),
            Arguments.of(new Input("After you"), new Output(".- ..-. - . .-. / -.-- --- ..-")),
            Arguments.of(
                new Input("Four score and 7 years ago"),
                new Output(
                    "..-. --- ..- .-. / ... -.-. --- .-. . / .- -. -.. / --... / -.-- . .- .-. ..."
                        + " / .- --. ---")),
            Arguments.of(
                new Input("abcdefghijklmnopqrstuvwxyz"),
                new Output(
                    ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ..."
                        + " - ..- ...- .-- -..- -.-- --..")));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new MorseEnc().encode(input.message));
        });
  }
}