package Main8;

import java.util.Scanner;

public class Main8_3 {
    static int n, m, answer=Integer.MIN_VALUE;
    public void DFS(int L, int p_sum, int t_sum, int[] point, int[] time) {
        if(t_sum>m) return;
        if(L==n){
            answer = Math.max(p_sum, answer);
        }
        else {
            DFS(L+1, p_sum+point[L], t_sum+time[L], point, time);
            DFS(L+1, p_sum, t_sum, point, time);
        }
    }

    public static void main(String[] args) {
        Main8_3 T = new Main8_3();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //문제의 개수
        m = sc.nextInt(); //제한 시간
        int[] point = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            point[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        T.DFS(0, 0, 0, point, time);
        System.out.println(answer);
    }
}
