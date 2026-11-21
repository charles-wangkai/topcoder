public class MessageMess {
    String words[];
    int count;
    boolean possibles[];
    public String restore(String[] dictionary, String message) {
        words=dictionary;
        count=0;
        possibles=new boolean[message.length()+1];
        for (int i=0;i<possibles.length;i++) {
            possibles[i]=true;
        }
        String result=search(message);
        if (count>1) {
            return "AMBIGUOUS!";
        }
        else if (count==0) {
            return "IMPOSSIBLE!";
        }
        else {
            return result;
        }
    }

    String search(String message) {
        if (possibles[message.length()]==false) {
            return null;
        }
        String result=null;
        for (int i=0;i<words.length;i++) {
            if (count>1) {
                return null;
            }
            if (message.startsWith(words[i])) {
                String rest=message.substring(words[i].length());
                String temp;
                if (rest.equals("")) {
                    temp=words[i];
                    count++;
                }
                else {
                    temp=search(rest);
                    if (temp!=null) {
                        temp=words[i]+" "+temp;
                    }
                }
                if (temp!=null) {
                    if (result==null) {
                        result=temp;
                    }
                    else {
                        return null;
                    }
                }
            }
        }
        if (result==null) {
            possibles[message.length()]=false;
        }
        return result;
    }
}
