import java.util.ArrayList;
import java.util.Scanner;

public class Main2_3 {
    public String Solution(int n, int[] a, int[] b) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if(a[i]==b[i]) answer+="D";
            else if (a[i]==1 && b[i]==3) answer+="A";
            else if (a[i]==2 && b[i]==1) answer+="A";
            else if (a[i]==3 && b[i]==2) answer+="A";
            else answer+="B";
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2_3 T = new Main2_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for(char x : T.Solution(n, a, b).toCharArray()) {
            System.out.println(x);
        }
    }
}
