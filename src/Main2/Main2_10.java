package Main2;

import java.util.Scanner;

public class Main2_10 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int Solution(int n, int[][] arr) {
        int answer=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i+dx[k]; // 위, 오른, 아래, 왼쪽 네 방향의 x, y좌표
                    int ny = j+dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]) {
                        // 네 방향으로 이동했을 때 좌표가 배열 범위 안에 있어야 하고, 가운데 값보다 작아야 봉우리
                        flag = false; // 네 방향 중 한 방향의 값이 가운데 값보다 클 경우 false
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2_10 T = new Main2_10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.Solution(n, arr));
    }
}
