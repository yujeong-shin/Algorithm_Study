import java.util.Scanner;

public class Main2_4 {
    public void Solution(int n) {
        int a=1, b=1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c=a+b;
            System.out.print(c + " ");
            a=b;
            b=c;
        }
    }

    public static void main(String[] args) {
        Main2_4 T = new Main2_4();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        T.Solution(num);
    }
}
