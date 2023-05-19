package Main1;

import java.util.Scanner;

public class Main1_8 {
    public String Solution(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", ""); // 특수문자 제거
        // replace는 정규식 X, replace는 정규식 O
        // System.out.println(s);
        String revStr = new StringBuilder(s).reverse().toString();
        if(revStr.equals(s)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Main1_8 T = new Main1_8();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}
