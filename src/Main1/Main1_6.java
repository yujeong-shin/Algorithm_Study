package Main1;

import java.util.Scanner;

public class Main1_6 {
    public String Solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            // 알파벳의 현재 위치 i와 처음 발견된 위치 str.indexOf(str.charAt(i))가 같다
            // == 처음 등장한 알파벳이므로 answer에 추가. 같지 않다면 중복 문자이기 때문에 패스
            if(i == str.indexOf(str.charAt(i))) answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main1_6 T = new Main1_6();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
