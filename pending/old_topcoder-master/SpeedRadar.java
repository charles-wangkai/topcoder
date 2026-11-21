public class SpeedRadar {
    public static double averageSpeed(int minLimit, int maxLimit, int[] readings) {
        int total=0;
        int count=0;
        for (int i=0;i<readings.length;i++) {
            if (readings[i]<minLimit || readings[i]>maxLimit) {
                count++;
            }
            else {
                total+=readings[i];
            }
        }
        if (count*10>readings.length) {
            return 0;
        }
        else {
            return (double)total/(readings.length-count);
        }
    }
}
