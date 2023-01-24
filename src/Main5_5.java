import java.util.Scanner;
import java.util.Stack;

public class Main5_5 {
    public int Solution(String str) {
        int answer=0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(') stack.push(str.charAt(i));
            else {
                stack.pop();
                if(str.charAt(i-1)=='(') answer += stack.size();
                else answer += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main5_5 T = new Main5_5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}