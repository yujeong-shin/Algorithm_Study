import java.util.Scanner;

public class Main2_8 {
    public int[] Solution(int n, int[] arr) {
        int[] answer = new int[n];
        int rank=0, cnt=0;
        for (int i = 0; i < n; i++) { // 배열 n개에 대해 i번 반복
            cnt=1;
            for (int j = 0; j < n; j++) { // 최대값 찾는 작업 j번 반복
                if(arr[j]>arr[i]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2_8 T = new Main2_8();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : T.Solution(num, arr))
            System.out.print(x + " ");
    }
}
