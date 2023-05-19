package Main2;

import java.util.Scanner;

public class Main2_12 {
//    public int Solution(int m, int n, int[][] arr) {
//        int cnt, answer=0;
//        for (int i = 0; i < n; i++) {
//            cnt=0;
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < m; k++) {
//                    if(arr[k][i] > arr[k][j]) // 숫자가 작은 것이 등수가 높은 것
//                        cnt++;
//                }
//                if(cnt==3) answer++;
//            }
//        }
//        return answer;
//    }

    public int Solution(int n, int m, int[][] arr) { // n : 학생 수, m : 테스트 수
        int answer=0;
        for (int i = 1; i <= n; i++) { // i : 멘토, j : 멘티
            for (int j = 1; j <= n; j++) { // 상위 두개 for문은 등수를 비교할 학생을 지정
                int cnt=0;
                for (int k = 0; k < m; k++) { // 각 테스트마다 (멘토, 멘티)의 등수를 구해 비교
                    int pi=0, pj=0; // pi : 멘토의 등수, pj : 멘티의 등수
                    for (int s = 0; s < n; s++) {
                        if(arr[k][s] == i) pi=s; // 배열 안의 값 : 학생 번호, 배열의 열 인덱스 번호 : 학생 등수
                        if(arr[k][s] == j) pj=s;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt==m) answer++; // cnt가 테스트 수와 같다면 모든 테스트에서 멘토의 점수가 높은 것
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2_12 T = new Main2_12();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 테스트 수
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.Solution(n, m, arr));
    }
}