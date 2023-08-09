package Main5;

import java.util.Scanner;
import java.util.Stack;

public class Main5_4 {
    public int Solution(String str) {
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) stack.push(x-48);
            else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(x=='+') stack.push(lt+rt);
                else if(x=='-') stack.push(lt-rt);
                else if(x=='*') stack.push(lt*rt);
                else if(x=='/') stack.push(lt/rt);
            }
        }
        answer = stack.get(0); //stack.pop();
        return answer;
    }
    public static void main(String[] args) {
        Main5_4 T = new Main5_4();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
