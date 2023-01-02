import java.util.Scanner;

public class Main2_9 {
    public int Solution(int n, int[][] arr) {
        int max=Integer.MIN_VALUE;
        int[] sum = new int[2*n+2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i] += arr[i][j]; // 각 행의 합
                sum[i+n] += arr[j][i]; // 각 열의 합
                if(i==j) sum[n+n] += arr[i][i]; // 우측 하향 대각선의 합
                sum[n+n+1] = arr[i][n-(i+1)]; // 좌측 하향 대각선의 합
            }
        }
        for (int i = 0; i < sum.length; i++) {
            if(sum[i]>max) max=sum[i];
        }
        return max;
    }

//    public int Solution(int n, int[][] arr) {
//        int answer = Integer.MIN_VALUE;
//        int sum1, sum2;
//        for (int i = 0; i < n; i++) {
//            sum1=sum2=0; // sum1 : 행의 합, sum2 : 열의 합
//            for (int j = 0; j < n; j++) {
//                sum1 += arr[i][j];
//                sum2 += arr[j][i];
//            }
//            answer = Math.max(answer, sum1);
//            answer = Math.max(answer, sum2);
//        }
//        sum1=sum2=0; // sum1 : 우측 하향 대각선의 합, sum2 : 좌측 하향 대각선의 합
//        for (int i = 0; i < n; i++) {
//            sum1 += arr[i][i];
//            sum2 += arr[i][n-i-1];
//        }
//        answer = Math.max(answer, sum1);
//        answer = Math.max(answer, sum2);
//        return answer;
//    }

    public static void main(String[] args) {
        Main2_9 T = new Main2_9();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.Solution(num, arr));
    }
}