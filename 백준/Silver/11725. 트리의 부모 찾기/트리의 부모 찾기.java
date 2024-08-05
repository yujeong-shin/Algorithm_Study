import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] parent;
    static public void BFS(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        while (!deque.isEmpty()) {
            int cv = deque.poll();
            for (int nv : graph.get(cv)) {
                if(!visited[nv]) {
                    visited[nv] = true;
                    parent[nv] = cv;
                    deque.add(nv);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        graph = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[N+1];
        parent = new int[N+1];
        visited[1] = true;
        BFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}