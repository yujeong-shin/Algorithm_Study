import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count;
    static int[][] graph;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        // 한 줄 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한 줄 안에서 공백 기준으로 자르기
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 자른거 하나씩 저장
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        graph = new int[N+1][N+1];
        ch = new int[N+1];
        for(int i=0; i<M; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        count=0;
        Main.Solution();
        System.out.println(count);
    }
    public static void Solution() {
        for (int i = 1; i < N+1; i++) {
            if(ch[i]==0) {
                count++;
                DFS(i);
            }
        }
    }
    public static void DFS(int v) {
        if(ch[v]==1) return;
        else {
            ch[v]=1;
            for(int i=1; i<N+1; i++) {
                if(graph[v][i]==1) {
                    DFS(i);
                }
            }
        }
    }
}
