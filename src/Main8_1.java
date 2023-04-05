import java.util.Scanner;

public class Main8_1 {
    static String answer="NO";
    static int n, total=0;
    boolean flag = false;
    public void DFS(int L, int sum, int[] arr) {
        if(flag) return; //답을 찾은 경우 더 이상 찾지 않게 스택 비우기
        if(sum>total/2) return; //가지치기를 하다 합이 절반 값이 넘어가면 이미 답이 아님
        if(L==n){
            if((total-sum)==sum) {
                answer="YES";
                flag=true;
            }
        }
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Main8_1 T = new Main8_1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total+=arr[i];
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}