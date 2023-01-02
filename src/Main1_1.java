import java.util.Scanner;

public class Main1_1 {
    // 문자 찾기
    public int solution(String str, char c) {
        int answer = 0;
        str = str.toUpperCase(); // 문자열 대문자 변환
        c = Character.toUpperCase(c); // 문자 대문자 변환
        for(char x : str.toCharArray()) {
            if(x==c) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main1_1 T = new Main1_1();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0); // 입력받은 문자열에서 특정 위치의 문자 얻기

        System.out.println(T.solution(str, c));
    }
}
