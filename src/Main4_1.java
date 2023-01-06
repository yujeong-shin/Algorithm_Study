import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main4_1 {
    public char Solution(int n, String s) {
        char answer=' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int max=Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;

//        int score[] = new int[arr.length];
//        for(char x : arr) {
//            if(x=='A') score[0]++;
//            else if(x=='B') score[1]++;
//            else if(x=='C') score[2]++;
//            else if(x=='D') score[3]++;
//            else score[4]++;
//        }
//        System.out.println(Arrays.toString(score));
//
//        int max_index=0, max=Integer.MIN_VALUE;
//        for (int i = 0; i < score.length; i++) {
//            if(max < score[i]) {
//                max = score[i];
//                max_index = i;
//            }
//        }
//        if(max_index==0) return 'A';
//        else if(max_index==1) return 'B';
//        else if(max_index==2) return 'C';
//        else if(max_index==3) return 'D';
//        else return 'E';
    }

    public static void main(String[] args) {
        Main4_1 T = new Main4_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.Solution(n, str));
    }
}
