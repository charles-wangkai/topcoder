import java.util.Scanner;

public class HowEasy {
    public static int pointVal(String param0) {
        Scanner in=new Scanner(param0);
        int total=0;
        int count=0;
        while (in.hasNext()==true) {
            String str=in.next();
            if (isWord(str)==true) {
                if (str.charAt(str.length()-1)!='.') {
                    total+=str.length();
                }
                else {
                    total+=str.length()-1;
                }
                count++;
            }
        }
        int average=0;
        if (count!=0) {
            average=total/count;
        }
        if (average<=3) {
            return 250;
        }
        else if (average<=5) {
            return 500;
        }
        else {
            return 1000;
        }
    }

    static boolean isWord(String str) {
        int end;
        if (str.charAt(str.length()-1)=='.') {
            if (str.length()==1) {
                return false;
            }
            end=str.length()-1;
        }
        else {
            end=str.length();
        }
        for (int i=0;i<end;i++) {
            char ch=str.charAt(i);
            if ((ch<'a' || ch>'z') && (ch<'A' || ch>'Z')) {
                return false;
            }
        }
        return true;
    }
}
