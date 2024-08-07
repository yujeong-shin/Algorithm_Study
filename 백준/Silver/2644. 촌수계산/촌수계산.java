import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class DegreeOfPerson {
    int num, count;
    public DegreeOfPerson(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
public class Main {
    static int N, M, person_A, person_B;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph;
    public static int BFS() {
        int answer = -1;
        Deque<DegreeOfPerson> deque = new ArrayDeque<>();
        deque.add(new DegreeOfPerson(person_A, 0));
        visited[person_A] = true;

        while (!deque.isEmpty()) {
            DegreeOfPerson cur = deque.poll();
            if(cur.num == person_B) {
                return cur.count;
            }
            for(int next : graph.get(cur.num)) {
                if(!visited[next]) {
                    visited[next] = true;
                    deque.add(new DegreeOfPerson(next, cur.count+1));
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        person_A = Integer.parseInt(st.nextToken());
        person_B = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(BFS());
    }
}