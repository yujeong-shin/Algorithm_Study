package Main4;

import java.util.HashMap;
import java.util.Scanner;

public class Main4_4 {
    public int Solution(String a, String b) {
//        int answer=0, cnt;
//        HashMap<Character, Integer> hm = new HashMap<>();
//        for (int i = 0; i <= s.length()-t.length(); i++) {
//            for (int j = i; j < i+t.length(); j++) {
//                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)+1);
//            }
//            for(char x : t.toCharArray()) {
//                hm.put(x, hm.getOrDefault(x, 0)-1);
//            }
//            cnt=0;
//            for (char key : hm.keySet()) {
//                if(hm.get(key)==0) cnt++;
//            }
//            if(cnt==t.length()) answer++;
//            hm.clear();
//        }
//        return answer;

        int answer=0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for (char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0)+1);
        int L = b.length()-1;
        for (int i = 0; i < L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);

        int lt=0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
            if(am.equals(bm)) answer++;
            am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main4_4 T = new Main4_4();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(T.Solution(a, b));
    }
}
