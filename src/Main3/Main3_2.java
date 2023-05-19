package Main3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3_2 {
    public ArrayList<Integer> Solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0, p2=0;
        while(p1<n && p2<m) {
            if(a[p1]==b[p2]) {
                answer.add(a[p1++]);
                p2++;
            }
            else if (a[p1]<b[p2]) p1++;
            else p2++;
        }
        return answer;
    }


    public static void main(String[] args) {
        Main3_2 T = new Main3_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        for (int x : T.Solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }
}
