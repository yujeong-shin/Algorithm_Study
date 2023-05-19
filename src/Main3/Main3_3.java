package Main3;

import java.util.Scanner;

public class Main3_3 {
    public int Solution(int n, int k, int[] arr) {
        int answer, sum=0;
        for (int i = 0; i < k; i++) sum += arr[i];
        answer=sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i-k]); // 첫 숫자 빼주고 다음 숫자 더하기
            answer = Math.max(sum, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main3_3 T = new Main3_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.Solution(n, k, arr));
    }
}
