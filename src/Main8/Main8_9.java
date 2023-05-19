package Main8;

import java.util.Scanner;

public class Main8_9 {
    static int n, m;
    static int[] combi;
    public void DFS(int L, int s) {  // 4 2
        if(L==m){
            for(int x : combi) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Main8_9 T = new Main8_9();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        T.DFS(0, 1);
    }
}
