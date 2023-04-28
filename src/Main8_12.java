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
public class Main8_12 {
    static int m, n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static Queue<Point> Q=new LinkedList<>();
    public void BFS(){
        while(!Q.isEmpty()){
            Point cur = Q.poll();
            for (int i = 0; i <= 3; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[cur.x][cur.y]+1;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main8_12 T = new Main8_12();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) Q.offer(new Point(i, j));
            }
        }
        T.BFS();
        int answer = Integer.MIN_VALUE;
        // 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
        //토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
        boolean flag = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==0) flag = false; //0이 하나라도 있으면 토마토 못 익은 것
            }
        }

        if(flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer=Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
}