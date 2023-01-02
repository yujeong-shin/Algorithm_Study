import java.util.Scanner;

public class Main1_3 {
    // 문장 속 단어. 문장 속에서 가장 긴 단어 출력

    // 1. split() 사용

    public String Solution(String str) {
        String answer ="";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" "); // 공백으로 분리해서 각 단어를 배열에 넣기
        for(String x : s) {
            //System.out.println(x);
            int len = x.length();
            if(len>m) {
                m=len;
                answer = x;
            }
        }
        return answer;
    }


    /*
    // 2. indexOf() + substring() 사용
    public String Solution(String str) {
        String answer ="";
        int m = Integer.MIN_VanswerUE, pos;
        while((pos=str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len>m) {
                m=len;
                answer = tmp;
            }
            str = str.substring(pos+1); // 첫 번째 단어를 제외한 문장으로 while 작업 반복
        }
        if(str.length()>m) answer=str; // 마지막 단어는 공백이 없으니까 예외로 비교 및 처리

        return answer;
    }
    */
    public static void main(String[] args) {
        Main1_3 T = new Main1_3();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}