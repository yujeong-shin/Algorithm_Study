import java.io.*;
import java.util.*;

class knight {
    int x, y, cnt;
    public knight(int x, int y, int cnt){
        this.x = x;
        this.y =y ;
        this.cnt = cnt;
    }
}
public class Main {
    public static void BFS(int startX, int startY, int endX, int endY) {
        Deque<knight> deque = new ArrayDeque<>();
        deque.add(new knight(startX, startY, 0));
        visited[startX][startY] = true;

        while (!deque.isEmpty()) {
            knight cur = deque.poll();
            if(cur.x == endX && cur.y == endY) {
                System.out.println(cur.cnt);
                return;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = dx[i] + cur.x;
                int nextY = dy[i] + cur.y;
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    deque.add(new knight(nextX, nextY, cur.cnt+1));
                }
            }
        }
    }
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int N;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());

            if(sX == eX && sY == eY) {
                System.out.println(0);
            }
            else {
                BFS(sX, sY, eX, eY);
            }
        }
    }
}