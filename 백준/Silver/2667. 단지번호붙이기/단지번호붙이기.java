import java.io.*;
import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, dangiCnt;
    static int[][] map;
    public static int BFS(int cx, int cy){
        Deque<Point> deque = new ArrayDeque<>();
        int zipCnt=1;
        deque.add(new Point(cx, cy));
        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]==1) {
                    map[nx][ny]=0;
                    zipCnt++;
                    deque.add(new Point(nx, ny));
                }
            }
        }
        return zipCnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        List<Integer> zipCnt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String inputStr = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(inputStr.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    map[i][j]=0;
                    dangiCnt++;
                    int count = BFS(i, j);
                    zipCnt.add(count);
                }
            }
        }

        int[] answers = new int[dangiCnt];
        for (int i = 0; i < zipCnt.size(); i++) {
            answers[i] = zipCnt.get(i);
        }
        Arrays.sort(answers);
        System.out.println(dangiCnt);
        for(int answer : answers) {
            System.out.println(answer);
        }
    }
}