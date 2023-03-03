import java.util.Arrays;
import java.util.Scanner;

public class Main6_9 {
    public int count(int[] arr, int capacity) { // capacity : 용량, mid 값
        int cnt=1, sum=0; //cnt:DVD 장 수, sum:DVD에 담는 곡들의 양
        for(int x: arr) {
            if(sum+x>capacity){
                cnt++;
                sum=x; // sum=0; sum+=x;와 동일
            }
            else {
                sum+=x;
            }
        }
        return cnt;
    }

    public int Solution(int n, int m, int[] arr) {
        int answer=0;
        // lt는 배열에서 가장 큰 값 = n장에 담았을 때 가장 큰 값
        int lt = Arrays.stream(arr).max().getAsInt(); //기본형 int를 리턴하지 않기 때문에 .getAsInt() 사용해야 함
        int rt = Arrays.stream(arr).sum();
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if(count(arr, mid)<=m) {
                answer=mid;
                rt=mid-1;
            }
            else lt=mid+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main6_9 T = new Main6_9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.Solution(n, m, arr));
    }
}
