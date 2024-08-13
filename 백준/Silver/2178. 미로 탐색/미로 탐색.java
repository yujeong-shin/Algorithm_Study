import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Miro {
    int x, y, cnt;
    public Miro(int x, int y, int cnt){
        this.x = x;
        this.y =y ;
        this.cnt = cnt;
    }
}
public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int N, M;
    static boolean[][] visited;
    static int[][] map;
    static void BFS() {
        Deque<Miro> deque = new ArrayDeque<>();
        visited[1][1] = true;
        deque.add(new Miro(1, 1, 1));
        while (!deque.isEmpty()) {
            Miro cur = deque.poll();
//            System.out.println("x : " + cur.x + ", y : " + cur.y + ", count : " + cur.cnt);
            if(cur.x == N && cur.y == M) {
                System.out.println(cur.cnt);
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if(nx>=1 && nx<=N && ny>=1 && ny<=M && !visited[nx][ny] && map[nx][ny]==1) {
                    visited[nx][ny] = true;
                    deque.add(new Miro(nx, ny, cur.cnt+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j-1)));
            }
        }
        BFS();
    }
}