import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main5_7 {
//    public String Solution(String k, String n) {
//        String answer="NO";
//        Queue<Character> Q = new LinkedList<>();
//        for (int i = 0; i < n.length(); i++) Q.offer(n.charAt(i));
//
//        int cnt=0;
//        for (int i = 0; i < n.length(); i++) {
//            if(cnt<k.length() && Q.peek()==k.charAt(cnt)){
//                Q.offer(Q.poll());
//                cnt++;
//            }
//            else Q.poll();
//        }
//        String tmp="";
//        Iterator iter = Q.iterator();
//        while(iter.hasNext())
//            tmp+=iter.next();
//        if(tmp.equals(k)) answer="YES";
//
//        return answer;
//    }
    public String Solution(String need, String plan) {
        String answer="YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x : need.toCharArray()) Q.offer(x);
        for(char x : plan.toCharArray()) {
            if(Q.contains(x))
                if(x!=Q.poll()) return "NO";
        }
        if(!Q.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Main5_7 T = new Main5_7();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(T.Solution(a, b));
    }
}
