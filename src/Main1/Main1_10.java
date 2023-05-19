package Main1;

import java.util.Scanner;

public class Main1_10 {
    public int[] Solution(String s, char c) {
        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) { // 입력받은 문자라면 0
                p=0;
                answer[i] = p;
            }
            else { // 아니라면 +1해서 저장
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == c) p=0;
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main1_10 T = new Main1_10();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);
        for(int x : T.Solution(str, ch)) {
            System.out.print(x + " ");
        }
    }
}
