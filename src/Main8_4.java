import java.util.Scanner;

public class Main8_4 {
    static int n, m;
    static int[] arr;
    public void DFS(int L){
        if(L==m) {
            for(int x : arr) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for (int i = 1; i <= n; i++) {
                arr[L]=i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        Main8_4 T = new Main8_4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //번호
        m = sc.nextInt(); //뽑는 횟수
        arr = new int[m];
        T.DFS(0);
    }
}
