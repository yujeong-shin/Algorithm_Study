import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static int n, m, time;
    static int[][] map;
    static ArrayList<Integer> cheese;
    static boolean[][] visited;
    static boolean flag = true;
    public static void BFS(int startX, int startY) {
        int countCheese = 0;
        visited = new boolean[n+1][m+1];
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(startX, startY));
        while(!deque.isEmpty()) {
            Point cur = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=0 && nx<=n && ny>=0 && ny<=m && !visited[nx][ny]) {
                    visited[nx][ny]=true;
                    if(map[nx][ny]==1) {
                        map[nx][ny]=0;
                        countCheese++;
                    }
                    else{
                        deque.add(new Point(nx, ny));
                    }
                }
            }
        }
        if(countCheese==0) {
            flag = false;
            return;
        }
        time++;
        cheese.add(countCheese);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        cheese = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(flag) {
            BFS(0, 0);
        }
        System.out.println(time);
        System.out.println(cheese.get(cheese.size()-1));
    }
}