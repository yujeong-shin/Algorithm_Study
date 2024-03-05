import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2인팀 ~ n/2인까지 팀 조합구하기
        for(int i=2; i<=n/2; i++){ // 1인 팀 vs 다수 팀은 1인 팀이 무조건 0점이기 때문에 계산 제외
            DFS(i, 0, 1);
        }
        System.out.println(min);
    }

    static void DFS(int limit, int L, int start){
        if(L == limit){
            // link 팀과 start 팀 점수의 차의 최솟값 구하기
            min = Math.min(min, calcDiff());
        }
        else{
            for (int i = start; i <= n; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    DFS(limit, L+1, i+1);
                    visited[i] = false;
                }
            }
        }
    }

    static int calcDiff(){
        int linkSum=0, startSum=0;
        List<Integer> link = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(visited[i]) link.add(i); //참일 경우 link 팀
            else start.add(i); //거짓일 경우 start 팀
        }

        // 각 팀의 점수 합산
        // link
        for (int i = 0; i < link.size()-1; i++) {
            for (int j = i+1; j < link.size(); j++) {
                linkSum += map[link.get(i)][link.get(j)];
                linkSum += map[link.get(j)][link.get(i)];
            }
        }

        // start
        for (int i = 0; i < start.size()-1; i++) {
            for (int j = i+1; j < start.size(); j++) {
                startSum += map[start.get(i)][start.get(j)];
                startSum += map[start.get(j)][start.get(i)];
            }
        }

        // 차이의 절대값 반환
        int diff = Math.abs(linkSum-startSum);
        return diff;
    }
}
