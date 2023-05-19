package Main8;

import java.util.Scanner;

public class Main8_5 {
    static int n, m, answer=Integer.MAX_VALUE;
    static int[] arr;
    public void DFS(int L, int sum){
        if(sum>m) return;
        if(sum==m){
            answer = Math.min(L, answer);
        }
        else{
            for (int i = 0; i < n; i++) {
                DFS(L+1, sum+arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main8_5 T = new Main8_5();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //동전개수
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        T.DFS(0, 0);
        System.out.println(answer);
    }
}