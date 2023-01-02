import java.util.Scanner;

public class Main1_5 {
    public String Solution(String str) {
        String answer = "";
        char[] s = str.toCharArray();
        int lt=0, rt=str.length()-1;
        while(lt < rt) {
            if(!Character.isAlphabetic(s[lt])) lt++; // 좌측 포인트가 특수문자라면 다음 포인트로 이동
            else if(!Character.isAlphabetic(s[rt])) rt--; // 우측 포인트가 특수문자라면 다음 포인트로 이동
            else { // 좌측 포인트, 우측 포인트 모두 숫자라면 교환
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);
        return answer;
    }

    public static void main(String[] args) {
        Main1_5 T = new Main1_5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
