
public class AccessChanger {

    public String[] convert(String[] program) {
        String converted[] = new String[program.length];
        for (int i = 0; i < converted.length; i++) {
            int commentPos = program[i].indexOf("//");
            if (commentPos >= 0) {
                converted[i] = program[i].substring(0, commentPos).replaceAll("->", ".") + program[i].substring(commentPos);
            } else {
                converted[i] = program[i].replaceAll("->", ".");
            }
        }
        return converted;
    }
}
