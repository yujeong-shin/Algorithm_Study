package Main10;

import java.util.Arrays;
import java.util.Scanner;

public class Main10_5 {
    static int[] dy;
    static int n, m;
    public int Solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) { //동전의 개수
            for (int j = coin[i]; j <= m; j++) { //동전의 금액부터 거스를 금액까지 반복
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }
    public static void main(String[] args) {
        Main10_5 T = new Main10_5();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy = new int[m+1];
        System.out.println(T.Solution(arr));
    }
}
