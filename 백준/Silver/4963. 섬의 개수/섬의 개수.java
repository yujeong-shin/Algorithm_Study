import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int w, h;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        //BufferReader 재영쓰 코드 루팡함
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> arr = new ArrayList<>();
        int count;
        while(true) {
            st = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count=0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(graph[i][j]==1) {
                        count++;
                        DFS(i, j);
                    }
                }
            }
            arr.add(count);
        }
        for(int tmp : arr) {
            System.out.println(tmp);
        }
    }
    public static void DFS(int x, int y){
        graph[x][y]=0;
        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<h && ny>=0 && ny<w && graph[nx][ny]==1){
                DFS(nx, ny);
            }
        }
    }
}