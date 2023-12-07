import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length(); //4
        if(len % 2 ==1) { //2
            answer = s.substring(len/2, len/2+1);
        }
        else { //
             answer = s.substring(len/2-1, len/2+1);
        }
        return answer;
    }
}