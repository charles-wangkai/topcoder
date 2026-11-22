public class Decoder {
  public boolean audit(String ssn) {
    int total = 0;
    int prefixSum = 0;
    for (char c : ssn.toCharArray()) {
      prefixSum += c - '0';
      total += prefixSum;
    }

    return total % 11 == 0;
  }
}
