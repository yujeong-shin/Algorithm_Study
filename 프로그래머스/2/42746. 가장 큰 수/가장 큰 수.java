import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strArr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strArr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
       answer = String.join("", strArr);
        if(answer.charAt(0)=='0') return "0";
        return answer;
    }
}