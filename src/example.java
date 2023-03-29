import java.util.*;

public class example {
    int answer=0;
    int dis[] = {1, -1, 5};
    int[] ch = new int[10001];
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        int L=0;
        Q.offer(s);
        ch[s] = 1;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                if(x==e) return L;
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if(nx>=1 && nx<=10000 && ch[nx]==0) {
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        example T = new example();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s, e));
    }
}