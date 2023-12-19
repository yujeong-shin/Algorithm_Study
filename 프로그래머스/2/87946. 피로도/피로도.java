import java.util.*;
class Solution {
    static int answer = 0; 
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        DFS(0, k, visited, dungeons);
        return answer;
    }
    
    static void DFS(int L, int k, boolean[] visited, int[][] dungeons){
        // if(L==dungeons.length){
        //     answer = Math.max(answer, L);
        //     return;
        // }
        // if(k<dungeons[L][0]){
        //     answer = Math.max(answer, L);
        //     return;
        // }

        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]) {
                visited[i]=true;
                DFS(L+1, k-dungeons[i][1], visited, dungeons);
                visited[i]=false;
            }
        }
        answer = Math.max(answer, L);
    }
}