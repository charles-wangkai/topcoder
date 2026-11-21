import java.util.ArrayList;

public class Prerequisites {
    public static String[] orderClasses(String[] param0) {
        int length=param0.length;
        boolean taken[]=new boolean[length];
        String classes[]=new String[length];
        ArrayList<Integer> pre[]=new ArrayList[length];
        for (int i=0;i<length;i++) {
            pre[i]=new ArrayList<Integer>();
        }
        for (int i=0;i<length;i++) {
            classes[i]=param0[i].split(":")[0];
        }
        boolean valid=true;
        for (int i=0;i<length;i++) {
            String str[]=param0[i].split(":");
            if (str.length>1) {
                str=str[1].split(" ");
                for (int j=0;j<str.length;j++) {
                    if (str[j].equals("")==false) {
                        valid=false;
                        for (int k=0;k<length;k++) {
                            if (str[j].compareTo(classes[k])==0) {
                                pre[i].add(k);
                                valid=true;
                                break;
                            }
                        }
                        if (valid==false) {
                            break;
                        }
                    }
                }
                if (valid==false) {
                    break;
                }
            }
        }
        if (valid==false) {
            return new String[0];
        }
        String result[]=new String[length];
        for (int i=0;i<length;i++) {
            int pos=-1;
            for (int j=0;j<length;j++) {
                if (taken[j]==false && pre[j].size()==0) {
                    if (pos==-1) {
                        pos=j;
                    }
                    else {
                        int number1=parse(classes[pos]);
                        int number2=parse(classes[j]);
                        if (number2<number1) {
                            pos=j;
                        }
                    }
                }
            }
            if (pos==-1) {
                return new String[0];
            }
            result[i]=classes[pos];
            taken[pos]=true;
            for (int j=0;j<length;j++) {
                pre[j].remove(new Integer(pos));
            }
        }
        return result;
    }

    static int parse(String str) {
        int number=0;
        int start=0;
        while (true) {
            char ch=str.charAt(start);
            if (ch>='0' && ch<='9') {
                break;
            }
            start++;
        }
        for (int i=start;i<str.length();i++) {
            number=number*10+(str.charAt(i)-'0');
        }
        return number;
    }
}
