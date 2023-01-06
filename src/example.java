import java.util.HashMap;
import java.util.Scanner;

public class example {
    public char Solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(max < map.get(key)) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        example T = new example();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.Solution(n, str));
    }
}