import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        System.out.println(BFS(A, B));
    }

    static int BFS(long start, long end){
        int count=0;
        Queue<Long> Q = new LinkedList<>();
        boolean[] visited = new boolean[(int) (end+1)];
        Q.add(start);
        visited[(int)start]=true;

        while(!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                long cur = Q.poll();
                if(cur==end) return count+1;

                //1번 연산. X2
                long tmp = cur*2;
                if(tmp <=end && !visited[(int)tmp]){
                    visited[(int)tmp]=true;
                    Q.add(tmp);
                }

                //2번 연산. X10 +1
                tmp = cur*10+1;
                if(tmp <=end && !visited[(int)tmp]){
                    visited[(int)tmp]=true;
                    Q.add(tmp);
                }
            }
            count++;
        }
        return -1;
    }
}
