package Main4;

import java.util.HashMap;
import java.util.Scanner;

public class Main4_2 {
    public String Solution(String s1, String s2) {
        String answer="YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char x : s2.toCharArray()) {
            if(!map.containsKey(x) || map.get(x)==0) // 같은 문자가 없거나 개수가 다른 경우
                return "NO";
            map.put(x, map.get(x)-1);
        }
        return answer;

//        String answer = "NO";
//        int com_cnt=0;
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//        for(char x : str1.toCharArray()) map1.put(x, map1.getOrDefault(x, 0)+1);
//        for(char x : str2.toCharArray()) map2.put(x, map2.getOrDefault(x, 0)+1);
//        for(char x : map1.keySet()) {
//            if(map1.get(x)==map2.get(x)) com_cnt++;
//        }
//        if(com_cnt==map1.size()) answer="YES";
//        return answer;
    }

    public static void main(String[] args) {
        Main4_2 T = new Main4_2();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(T.Solution(a, b));
    }
}
