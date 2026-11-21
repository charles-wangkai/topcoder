
public class ObjectPacking {

    public int smallBox(int objWidth, int objLength, int[] boxWidth, int[] boxLength) {
        int minArea = -1;
        for (int i = 0; i < boxWidth.length; i++) {
            if (((objWidth <= boxWidth[i] && objLength <= boxLength[i]) || (objWidth <= boxLength[i] && objLength <= boxWidth[i])) && (minArea < 0 || boxWidth[i] * boxLength[i] < minArea)) {
                minArea = boxWidth[i] * boxLength[i];
            }
        }
        return minArea;
    }
}
