import java.util.*;
class Sequence{
    int start;
    int end;

    public Sequence(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        List<Sequence> answers = new ArrayList<>();

        int sum=0;
        int lt=0;
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            if(sum==k) answers.add(new Sequence(lt, rt));

            if(sum>k){
                while(sum>k){
                    sum -= sequence[lt];
                    lt++;
                    if(sum==k) answers.add(new Sequence(lt, rt));
                }
            }
        }

        int minLength = Integer.MAX_VALUE;
        int i=0;
        int minIndex = 0;
        // 정답 후보들을 모두 돌면서 길이가 가장 짧은 길이 찾기
        List<Sequence> minLenSequences = new ArrayList<>();
        for(Sequence sequence1 : answers){
            i++;
            int sequence_len = sequence1.end - sequence1.start;
            if(sequence_len <= minLength) {
                minLength = sequence_len;
            }
        }

        // 가장 짧은 길이 정답 후보들 List에 새로 넣어주기
        for(Sequence sequence1 : answers){
            int sequence_len = sequence1.end - sequence1.start;
            if(sequence_len == minLength) minLenSequences.add(sequence1);
        }

        // 길이가 가장 짧은 여러 개의 정답 후보들 중, 시작 인덱스 가장 낮은 것 찾기
        int minStart = Integer.MAX_VALUE;
        for(Sequence sequence1 : minLenSequences){
            if(sequence1.start < minStart){
                minStart = sequence1.start;
                answer[0] = sequence1.start;
                answer[1] = sequence1.end;
            }
        }
        
        return answer;
    }
}