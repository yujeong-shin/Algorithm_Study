import java.util.Scanner;

public class Main2_7 {
    public int Solution(int n, int[] arr) {
        int answer=0, point=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==0) point=0;
            else {
                point++;
                answer += point;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2_7 T = new Main2_7();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.Solution(num, arr));
    }
}
