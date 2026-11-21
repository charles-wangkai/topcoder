public class SymbolFrequency {
    public static double language(String[] frequencies, String[] text) {
        int total=0;
        int actuals[]=new int[26];
        for (int i=0;i<text.length;i++) {
            for (int j=0;j<text[i].length();j++) {
                char ch=text[i].charAt(j);
                if (ch!=' ') {
                    total++;
                    actuals[ch-'a']++;
                }
            }
        }
        double min=Integer.MAX_VALUE;
        for (int i=0;i<frequencies.length;i++) {
            double expects[]=new double[26];
            for (int j=0;j<frequencies[i].length()/3;j++) {
                char ch=frequencies[i].charAt(j*3);
                int number=Integer.parseInt(frequencies[i].substring(j*3+1,j*3+3));
                expects[ch-'a']=total*number/100.0;
            }
            double sum=0;
            for (int j=0;j<26;j++) {
                sum+=(expects[j]-actuals[j])*(expects[j]-actuals[j]);
            }
            if (sum<min) {
                min=sum;
            }
        }
        return min;
    }
}
