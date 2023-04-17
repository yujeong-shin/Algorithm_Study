import java.util.Scanner;

public class Main8_7 {
    static int[][] m;
    public int DFS(int n, int r){
        if(m[n][r]>0) return m[n][r];
        if(n==r || r==0) return 1;
        else return m[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }

    public static void main(String[] args) {
        Main8_7 T = new Main8_7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        m = new int[n+1][n+1];
        T.DFS(n, r);
        System.out.println(m[n][r]);
    }
}
