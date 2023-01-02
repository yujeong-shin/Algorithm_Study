import java.util.Scanner;

public class Main1_7 {
    public String Solution(String str) {
        String answer = "NO";
        String revStr = new StringBuilder(str).reverse().toString();
        if(revStr.equalsIgnoreCase(str)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Main1_7 T = new Main1_7();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
