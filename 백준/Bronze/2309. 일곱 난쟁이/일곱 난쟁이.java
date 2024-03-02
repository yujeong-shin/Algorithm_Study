import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.exit;

public class Main {
    static int[] nanjangeKey;
    static boolean[] visited;
    static final int n=9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nanjangeKey = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nanjangeKey[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nanjangeKey);
        DFS(0, 0);
    }
    static void DFS(int L, int sum){
        if(L==7){
            if(sum == 100){
                for (int i = 0; i < n; i++) {
                    if(visited[i]){
                        System.out.println(nanjangeKey[i]);
                    }
                }
                exit(0);
            }
        }
        else{
            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    int s = sum + nanjangeKey[i];
                    DFS(L+1, s);
                    visited[i] = false;
                }
            }
        }
    }
}
