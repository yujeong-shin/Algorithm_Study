import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.fill(dp, 9999999);
        dp[0] = 0;
        for(int i=0; i<n; i++) {
            if(coin[i] <= 0) {
                continue;
            }
            for(int j=coin[i]; j<=k; j++) {
                dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
            }
        }
        
        if(dp[k] == 9999999) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[k]);
        }
    }
}