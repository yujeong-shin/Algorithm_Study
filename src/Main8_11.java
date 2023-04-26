import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Point {
//    public int x, y;
//    Point(int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//}
public class Main8_11 {
    // 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램
    // 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    public void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        while(!Q.isEmpty()) {
            Point cur = Q.poll();

            for (int i = 0; i <= 3; i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main8_11 T = new Main8_11();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        T.BFS(1, 1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
