import java.util.Scanner;

public class Main6_3 {
    public int[] Solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if(tmp < arr[j]) {
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
                else break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Main6_3 T = new Main6_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : T.Solution(n, arr))
            System.out.print(x + " ");
    }
}
