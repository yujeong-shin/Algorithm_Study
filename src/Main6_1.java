import java.util.*;

public class Main6_1 {
    public int[] Solution(int n, int[] arr) {
        // 선택 정렬
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if(arr[min] > arr[j]) min = j;
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Main6_1 T = new Main6_1();
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
