import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int mapSize;
    static int[][] ch;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bf.readLine()); //체스판 한 변의 길이 입력
            mapSize = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine()); //나이트가 현재 있는 칸
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine()); //나이트가 이동하려는 칸
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            BFS(start_x, start_y, end_x, end_y);
        }
        for(int x : result) System.out.println(x);
    }
    public static void BFS(int s_x, int s_y, int e_x, int e_y){
        ch = new int[mapSize][mapSize];
        ch[s_x][s_y]=1;
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(s_x, s_y));
        //뻗어나간 Depth 깊이로 최단경로 찾기 = 정답
        int level=0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point cur = Q.poll();
                if(cur.x == e_x && cur.y == e_y) {
                    result.add(level);
                    return;
                }
                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx>=0 && nx<mapSize && ny>=0 && ny<mapSize && ch[nx][ny]==0) {
                        ch[nx][ny]=1;
                        Q.add(new Point(nx, ny));
                    }
                }
            }
            level++;
        }
    }
}