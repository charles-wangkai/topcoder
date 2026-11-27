import java.util.stream.IntStream;

public class MagicSqr {
  public int magicSum(int[] magicNums) {
    return search(magicNums, 0);
  }

  int search(int[] magicNums, int index) {
    if (index == magicNums.length) {
      return check(magicNums) ? (magicNums[0] + magicNums[1] + magicNums[2]) : -1;
    }

    for (int i = index; i < magicNums.length; ++i) {
      swap(magicNums, i, index);

      int subResult = search(magicNums, index + 1);
      if (subResult != -1) {
        return subResult;
      }

      swap(magicNums, i, index);
    }

    return -1;
  }

  void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  boolean check(int[] magicNums) {
    return IntStream.of(
                magicNums[0] + magicNums[1] + magicNums[2],
                magicNums[3] + magicNums[4] + magicNums[5],
                magicNums[6] + magicNums[7] + magicNums[8],
                magicNums[0] + magicNums[3] + magicNums[6],
                magicNums[1] + magicNums[4] + magicNums[7],
                magicNums[2] + magicNums[5] + magicNums[8],
                magicNums[0] + magicNums[4] + magicNums[8],
                magicNums[2] + magicNums[4] + magicNums[6])
            .distinct()
            .count()
        == 1;
  }
}
