import java.util.ArrayList;
import java.util.Scanner;

public class Main1_4 {
    // n개의 단어를 각각 뒤집어 출력

    // 1. StringBuilder 이용
//    public ArrayList<String> Solution(int n, String[] str) {
//        ArrayList<String> answer = new ArrayList<>();
//        for(String x : str) {
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }
//        return answer;
//    }

    /// 2. 직접 뒤집기
    public ArrayList<String> Solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;
            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s); // 문자배열 s를 스트링화 시켜줌.
                                            // static으로 선언된 클래스 메서드이기 때문에
                                            // 객체.vanswerueOf()가 아니라 클래스.vanswerueOf()로 사용
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main1_4 T = new Main1_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        for(String x : T.Solution(n, str)) {
            System.out.println(x);
        }
    }
}
