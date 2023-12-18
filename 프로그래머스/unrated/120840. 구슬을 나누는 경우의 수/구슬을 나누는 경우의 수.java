import java.util.*;
class Solution {
    static int answer=0;
    static int[] combi;
    public int solution(int balls, int share) { //3개 중 2개 뽑기
        combi = new int[share];
        recur(balls, share, 0, 0);
        return answer;
    }
    
    static void recur(int balls, int share, int L, int start){
        if(L==share){
            answer++;
            return;
        }
        else {
            for(int i=start; i<balls; i++) {
                combi[L]=i;
                recur(balls, share, L+1, i+1);
            }
        }
    }
}