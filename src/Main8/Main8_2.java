package Main8;

import java.util.Scanner;

public class Main8_2 {
    static int answer = Integer.MIN_VALUE, c, n;
    /*public int DFS(int L, int sum, int[] arr) {
        if(L==n) {
            if(sum<=c && sum>answer)
            answer = sum;
        }
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
        return answer;
    }*/
    public void DFS(int L, int sum, int[] arr){
        if(sum>c) return;
        if(L==n) {
            answer = Math.max(answer, sum);
        }
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Main8_2 T = new Main8_2();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //System.out.println(T.DFS(0, 0, arr));
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}