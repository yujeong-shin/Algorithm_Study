import java.util.*;

public class example {
    // N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
    // N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
    // 3     1     2     4
    //    4     3     6
    //       7     9
    //          16
    static int n, f;
    static int[] b, p, ch;
    static int[][] dy;
    boolean flag = false;

    public int combi(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n==r || r==0) return 1;
        else {
            return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
        }
    }

    public void DFS(int L, int sum){
        if(flag) return;
        if(L==n){
            if(sum==f) {
                for(int x : p) System.out.print(x + " ");
                flag = true;
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L+1, sum+b[L]*p[L]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        example T = new example();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        dy = new int[n+1][n+1];
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n-1, i);
        }
        T.DFS(0, 0);
    }
}