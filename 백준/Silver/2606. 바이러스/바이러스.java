import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static int BFS(int start) {
        int answer=0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        while(!deque.isEmpty()) {
            int cur = deque.poll();
            // ArrayList 줄줄이 소세지 가져옴 -> !visited라면 answer++, visited=t 후, deque 추가
            for(Integer next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    answer++;
                    deque.add(next);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;
        System.out.println(BFS(1));
    }
}