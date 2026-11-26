import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Triage {
  public String[] admitPatients(String[] patients, int frequency) {
    Patient[] ps =
        IntStream.range(0, patients.length)
            .mapToObj(i -> {
              String[] fields = patients[i].split("[:,]");
              int time = Integer.parseInt(fields[0]);
              String name = fields[1];
              int priority = Integer.parseInt(fields[2]);

              return new Patient(i, time, name, priority);
            })
            .toArray(Patient[]::new);

    List<String> result = new ArrayList<>();
    int index = 0;
    PriorityQueue<Patient> pq =
        new PriorityQueue<>(
            Comparator.comparing(Patient::priority).reversed().thenComparing(Patient::index));
    int time = frequency;
    while (index != ps.length || !pq.isEmpty()) {
      while (index != ps.length && ps[index].time < time) {
        pq.offer(ps[index]);
        ++index;
      }

      result.add(pq.isEmpty() ? "" : pq.poll().name);

      time += frequency;
    }

    return result.toArray(String[]::new);
  }

  record Patient(int index, int time, String name, int priority) {}
}
