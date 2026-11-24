public class TopCooler {
  public int payout(int divI, int divII) {
    if (divI > 512) {
      divI = 512;
      divII = 0;
    } else if (divI + divII > 512) {
      divII = 512 - divI;
    }

    if (divI + divII < 4) {
      return 0;
    }

    if (divI < 4 && divII < 4) {
      divI += divII;
      divII = 0;
    } else if (divI < 4) {
      divII += divI;
      divI = 0;
    } else if (divII < 4) {
      divI += divII;
      divII = 0;
    }

    return Math.ceilDiv(divI, 8) * 23 + Math.ceilDiv(divII, 8) * 13;
  }
}
