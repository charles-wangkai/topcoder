import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DeadLang_Test {
  record Input(int index, String alpha, String[] story) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(
                new Input(
                    4,
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                    new String[] {
                      "Three... two... one... Liftoff.", "Shuttle Discovery has lifted off."
                    }),
                new Output("LIFTOFF")),
            Arguments.of(
                new Input(
                    9,
                    "ZYXWVUTSRQPONMLKJIHGFEDCBA",
                    new String[] {"This is a lengthy story.  It keeps", "Going and going...."}),
                new Output("AND")),
            Arguments.of(
                new Input(
                    8,
                    "QWERTYUIOPASDFGHJKLZXCVBNM",
                    new String[] {"This is a lengthy story.  It keeps", "Going and going...."}),
                new Output("KEEPS")),
            Arguments.of(
                new Input(
                    3,
                    "QWERTYUIOPASDFGHJKLZXCVBNM",
                    new String[] {
                      "Three... two... one... Liftoff.", "Shuttle Discovery has lifted off."
                    }),
                new Output("OFF")));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(
              output.result, new DeadLang().dictEntry(input.index, input.alpha, input.story));
        });
  }
}