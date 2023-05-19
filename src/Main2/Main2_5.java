package Main2;

import java.util.Scanner;

public class Main2_5 {
    public int Solution(int n) {
        int answer=0;
        int[] ch = new int[n+1]; // 인덱스 n까지의 배열을 생성하기 위해
        for (int i = 2; i <= n; i++) {
            if(ch[i]==0) {
                answer++;
                for (int j = i; j <= n; j=j+i) ch[j] = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2_5 T = new Main2_5();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(T.Solution(num));
    }
}
