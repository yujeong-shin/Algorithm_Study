import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> myQue = new PriorityQueue<>();
        for(int num : scoville) myQue.add(num);

        while(true){
            if(myQue.peek() >= K) break;
            else if(myQue.size()==1 && myQue.peek() < K) {
                answer = -1;
                break;
            }
            else{
                answer++;
                int temp = myQue.poll() +  myQue.poll()*2;
                myQue.add(temp);
            }
        }
        return answer;
        
    }
}