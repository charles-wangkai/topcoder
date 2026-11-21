
public class TriangleType {

    public String type(int a, int b, int c) {
        if (a + b <= c || b + c <= a || c + a <= b) {
            return "IMPOSSIBLE";
        }
        int angleTypeA = calcAngleType(a, b, c);
        int angleTypeB = calcAngleType(b, c, a);
        int angleTypeC = calcAngleType(c, a, b);
        if (angleTypeA == 0 || angleTypeB == 0 || angleTypeC == 0) {
            return "RIGHT";
        } else if (angleTypeA > 0 || angleTypeB > 0 || angleTypeC > 0) {
            return "OBTUSE";
        } else {
            return "ACUTE";
        }
    }

    int calcAngleType(int a, int b, int c) {
        return (int) Math.signum(a * a - b * b - c * c);
    }
}
