package Main10;

import java.util.Scanner;

public class Main10_1 {
    static int dy[];
    public int Solution(int n) {
        dy[1] = 1; //1번 계단까지 갈 수 있는 방법의 수 : 1
        dy[2] = 2; //1번 계단까지 갈 수 있는 방법의 수 : 1+1, 2
        for (int i = 3; i<=n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n];
    }

    public static void main(String[] args){
        Main10_1 T = new Main10_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];
        System.out.println(T.Solution(n));
    }
}