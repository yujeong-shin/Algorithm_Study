import java.util.*;

class Solution {
    static PriorityQueue<Integer> pQ;
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        pQ = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(oper.equals("I")){
                pQ.add(num);
            }
            else {
                removeNum(num);
            }
        }

        if(pQ.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            PriorityQueue<Integer> pQ_rev = new PriorityQueue<>(Comparator.reverseOrder());
            for(Integer num : pQ) pQ_rev.add(num);
            answer[0] = pQ_rev.remove();
            answer[1] = pQ.remove();
        }
       return answer;
    }

    static void removeNum(int removeFlag){
        if(!pQ.isEmpty()){
            //최댓값 삭제
            if(removeFlag==1){
                PriorityQueue<Integer> pQ_rev = new PriorityQueue<>(Comparator.reverseOrder());
                for(Integer num : pQ) pQ_rev.add(num);
                int maxNum = pQ_rev.remove();
                pQ.remove(maxNum);
            }
            //최소값 삭제
            else{
                pQ.remove();
            }
        }
    }
}