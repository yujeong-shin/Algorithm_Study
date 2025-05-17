import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String target = br.readLine();
        int s_len = s.length();
        int target_len = target.length();

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            stack.push(c);
            if(stack.size() >= target_len){ // 덱 길이 >= 폭발 단어라면, 폭발 단어 체크
                int match_count = 0;
                for(int i=0; i<target_len; i++){
                    if(stack.get(stack.size() - target_len + i) == target.charAt(i)){
                        match_count++;
                    }
                }
                if(match_count == target_len){ // 폭발 단어 존재
                    for(int i=0; i<target_len; i++){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.size() == 0){
            System.out.println("FRULA");
        }
        else {
            for(char c : stack){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}