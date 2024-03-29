package Main3;

import java.util.Scanner;

public class Main3_5 {
//    public int Solution(int n) {
//        int answer=0, sum=0, lt=0;
//        int m=n/2+1;
//        int[] arr = new int[m];
//        for (int i = 0; i < m; i++) arr[i] = i+1;
//        for (int rt = 0; rt < m; rt++) {
//            sum += arr[rt];
//            if(sum==n) answer++;
//            while(sum>n) {
//                sum -= arr[lt++];
//                if(sum==n) answer++;
//            }
//        }
//        return answer;
//    }

    public int Solution(int n) {
        int answer=0, cnt=1; // cnt : 연속된 자연수의 개수
        n--;
        while (n>0) {
            cnt++;
            n = n-cnt;
            if(n%cnt==0) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main3_5 T = new Main3_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.Solution(n));
    }
}
