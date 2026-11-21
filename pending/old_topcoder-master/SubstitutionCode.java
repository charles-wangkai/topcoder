
public class SubstitutionCode {

    public int getValue(String key, String code) {
        int number = 0;
        for (int i = 0; i < code.length(); i++) {
            int index = key.indexOf(code.charAt(i));
            if (index >= 0) {
                number = number * 10 + (index + 1) % 10;
            }
        }
        return number;
    }
}
