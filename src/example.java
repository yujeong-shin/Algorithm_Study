import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class example {
    public int Solution(int n, int k, int[] a) {
        // 14 2
        //1 1 0 0 1 1 0 1 1 0 1 1 0 1
        int answer=0, cnt=0, lt=0;
        for (int rt = 0; rt < n; rt++) {
            if(a[rt]==0) cnt++;
            while(cnt>k) {
                if(a[lt]==0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        example T = new example();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(T.Solution(n, k, a));
    }
}
