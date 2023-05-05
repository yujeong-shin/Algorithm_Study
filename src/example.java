import java.util.*;

class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] board;
    static int n, answer=0;

    public void Solution() {
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1) {
                    board[i][j]=0;
                    DFS(i, j);
                    answer++;
                }
            }
        }
    }
    public void DFS(int x, int y) {
        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1) {
                board[nx][ny]=0;
                DFS(nx, ny);
            }
        }
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        T.Solution();
        System.out.println(answer);
    }
}