import java.util.Scanner;
import java.util.PriorityQueue;

public class MatchMaker {
    public static String[] getBestMatches(String[] members, String currentUser, int sf) {
        Member allMember[]=new Member[members.length];
        int index=-1;
        for (int i=0;i<allMember.length;i++) {
            Scanner in=new Scanner(members[i]);
            allMember[i]=new Member(i,in.next(),in.next(),in.next(),in.nextLine());
            if (allMember[i].name.compareTo(currentUser)==0) {
                index=i;
            }
        }
        PriorityQueue<Member> order=new PriorityQueue<Member>();
        for (int i=0;i<allMember.length;i++) {
            if (i!=index && allMember[i].gender.compareTo(allMember[index].requestedGender)==0) {
                int count=0;
                for (int j=1;j<allMember[i].answer.length();j+=2) {
                    if (allMember[i].answer.charAt(j)==allMember[index].answer.charAt(j)) {
                        count++;
                    }
                }
                if (count>=sf) {
                    allMember[i].similar=count;
                    order.offer(allMember[i]);
                }
            }
        }
        String result[]=new String[order.size()];
        for (int i=0;i<result.length;i++) {
            result[i]=order.poll().name;
        }
        return result;
    }

    static class Member implements Comparable<Member> {
        int index;
        String name;
        String gender;
        String requestedGender;
        String answer;
        int similar;

        public Member(int theIndex,String theName,String theGender,String theRequestedGender,String theAnswer) {
            this.index=theIndex;
            this.name=theName;
            this.gender=theGender;
            this.requestedGender=theRequestedGender;
            this.answer=theAnswer;
        }

        public int compareTo(Member another) {
            if (this.similar!=another.similar) {
                return another.similar-this.similar;
            }
            else {
                return this.index-another.index;
            }
        }
    }
}
