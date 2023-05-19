package Main2;

import java.util.Scanner;

public class Main2_11 {
//    public int Solution(int n, int[][] arr) {
//        int cnt[] = new int[n];
//        int num[] = new int[n];
//        for (int i = 0; i < n; i++) { // 학년
//            num[0] = arr[0][i];
//            num[1] = arr[1][i];
//            num[2] = arr[2][i];
//            num[3] = arr[3][i];
//            num[4] = arr[4][i];
//            for (int j = 0; j < n; j++) { // 같은 숫자의 학생 수 세기
//                if(arr[j][i] == num[0]) cnt[0]++;
//                if(arr[j][i] == num[1]) cnt[1]++;
//                if(arr[j][i] == num[2]) cnt[2]++;
//                if(arr[j][i] == num[3]) cnt[3]++;
//                if(arr[j][i] == num[4]) cnt[4]++;
//            }
//            for (int j = 0; j < n; j++) {
//                cnt[j]--; // 자기 자신의 경우 중복 숫자가 아니므로 빼주기
//            }
//        }
//        int answer=0;
//        for (int i = 0; i < n; i++) {
//            if(cnt[i] > answer) answer = cnt[i];
//        }
//        return answer;
//    }
    public int Solution(int n, int[][] arr) {
        int answer=0, max=Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int cnt=0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2_11 T = new Main2_11();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.Solution(n, arr));
    }
}
