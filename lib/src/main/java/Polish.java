import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Polish {
  static final Map<Character, Calculator> OPERATOR_TO_CALCULATOR =
      Map.ofEntries(
          entry('+', (x, y) -> x + y), entry('-', (x, y) -> x - y), entry('*', (x, y) -> x * y));

  public int evaluate(String expr) {
    String[] tokens =
        Arrays.stream(expr.split(" ")).filter(s -> !s.isEmpty()).toArray(String[]::new);

    List<Object> stack = new ArrayList<>();
    for (String token : tokens) {
      if (OPERATOR_TO_CALCULATOR.keySet().stream()
          .anyMatch(operator -> String.valueOf(operator).equals(token))) {
        stack.add(token.charAt(0));
      } else {
        stack.add(Integer.parseInt(token));
      }

      while (stack.size() >= 2
          && stack.get(stack.size() - 1) instanceof Integer
          && stack.get(stack.size() - 2) instanceof Integer) {
        int operand2 = (int) stack.removeLast();
        int operand1 = (int) stack.removeLast();
        char operator = (char) stack.removeLast();

        stack.add(OPERATOR_TO_CALCULATOR.get(operator).calculate(operand1, operand2));
      }
    }

    return (int) stack.getLast();
  }

  @FunctionalInterface
  interface Calculator {
    int calculate(int x, int y);
  }
}
