import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, sX, sY, eX, eY;
    static int[][] map, count;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sX = Integer.parseInt(st.nextToken());
        sY = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        eX = Integer.parseInt(st.nextToken());
        eY = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        count = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
    }
    static void BFS(){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{sX, sY, 0});
        visited[sX][sY][0] = true;
        count[sX][sY] = 0;

        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int curX = cur[0];
            int curY = cur[1];
            int brokeOnce = cur[2];
            if(curX == eX && curY == eY){
                System.out.println(count[eX][eY]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];
                if (nxtX >= 1 && nxtX <= N && nxtY >= 1 && nxtY <= M) {
                    if(map[nxtX][nxtY]==1 && brokeOnce == 0) {
                        count[nxtX][nxtY] = count[curX][curY] + 1;
                        deque.add(new int[]{nxtX, nxtY, 1});
                    }
                    else {
                        if(map[nxtX][nxtY]==0) {
                            if(!visited[nxtX][nxtY][brokeOnce]) {
                                visited[nxtX][nxtY][brokeOnce] = true;
                                count[nxtX][nxtY] = count[curX][curY] + 1;
                                deque.add(new int[]{nxtX, nxtY, brokeOnce});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}