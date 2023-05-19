package Main1;

import java.util.Scanner;

public class Main1_2 {
    // 대소문자 변환. 대->소, 소->대
    public String Solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()){
            if(x>=97 && x<=122) answer += (char)(x-32); // 아스키 코드 97:A, 122:Z, a:65, z:90
            else answer += (char)(x+32);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main1_2 T = new Main1_2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
