import java.util.Scanner;
import java.util.Stack;

public class Main5_1 {
    public String Solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x=='(') stack.push(x);
            else {
                if(stack.isEmpty()) answer="NO"; // (가 적어 짝이 안맞는 경우
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) answer="NO"; // (가 많아 짝이 안맞는 경우
        return answer;
    }
    public static void main(String[] args) {
        Main5_1 T = new Main5_1();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
