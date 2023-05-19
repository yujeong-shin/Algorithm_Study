package Main1;

import java.util.Scanner;

public class Main1_9 {
    public int Solution(String s) {
        String answer = "";
        for(char x : s.toCharArray()) {
            if(Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Main1_9 T = new Main1_9();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
