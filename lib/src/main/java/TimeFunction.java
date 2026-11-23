import java.util.Arrays;

public class TimeFunction {
  public String subtractTime(String time1, String time2) {
    return toTime(toValue(time1) - toValue(time2));
  }

  int toValue(String time) {
    int[] fields = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();

    return ((fields[0] * 60 + fields[1]) * 60 + fields[2]) * 1000 + fields[3];
  }

  String toTime(int value) {
    int rest = value;

    int milliseconds = rest % 1000;
    rest /= 1000;

    int seconds = rest % 60;
    rest /= 60;

    int minutes = rest % 60;
    rest /= 60;

    int hours = rest;

    return "%02d:%02d:%02d:%03d".formatted(hours, minutes, seconds, milliseconds);
  }
}
