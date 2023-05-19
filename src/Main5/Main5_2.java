package Main5;

import java.util.Scanner;
import java.util.Stack;

public class Main5_2 {
    public String Solution(String str) {
        String answer="";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x==')') {
                while(stack.pop()!='(');
            }
            else stack.push(x);
        }
//        for(char x : stack) answer+=x;
        for (int i = 0; i < stack.size(); i++) answer+=stack.get(i);

        return answer;
    }

    public static void main(String[] args) {
        Main5_2 T = new Main5_2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
