import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] DP = new int[K][N+1];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j <= N; j++) {
//                System.out.print("i : " + i + ", j : "+ j);
                if(i==0 || j==0) DP[i][j] = 1;
                else DP[i][j] = (DP[i][j-1] + DP[i-1][j]) % 1000000000;
//                System.out.println("   DP[" + i + "][" + j + "] = " + DP[i][j]);
            }
        }
        System.out.println(DP[K-1][N]);
    }
}