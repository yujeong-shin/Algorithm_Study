import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class NumAB {
    long num;
    int count;

    public NumAB(long num, int count) {
        this.num = num;
        this.count = count;
    }
}

public class Main {
    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        System.out.println(bfs());
    }

    static int bfs() {
        Deque<NumAB> deque = new ArrayDeque<>();
        deque.add(new NumAB(a, 0));

        while (!deque.isEmpty()) {
            NumAB cur = deque.poll();
            if (cur.num == b) {
                return cur.count + 1;
            }

            if (cur.num * 2 <= b) {
                deque.add(new NumAB(cur.num * 2, cur.count + 1));
            }
            if (cur.num * 10 + 1 <= b) {
                deque.add(new NumAB(cur.num * 10 + 1, cur.count + 1));
            }
        }

        return -1;
    }
}