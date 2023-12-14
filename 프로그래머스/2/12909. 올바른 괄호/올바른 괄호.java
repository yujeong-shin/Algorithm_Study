import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(') stack.push(c);
            else {
                if(stack.isEmpty()) answer=false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) answer=false;
        
        return answer;
    }
}