package Main6;

import java.util.Arrays;
import java.util.Scanner;

public class Main6_10 {
    public int count(int[] arr, int dist) {
        int cnt=1; // cnt: 배치한 말의 마리 수, 1마리 배치했다
        int ep=arr[0]; // ep: 바로 전에 배치한 말의 위치, 첫 번째 말을 맨 왼쪽 위에 놓았다고 가정
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= dist) {
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }

    public int Solution(int n, int c, int[] arr) {
        int answer=0;
        int lt = 1, rt=arr[n-1];
        Arrays.sort(arr);

        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if(count(arr, mid)>=c) { // c마리 수 이상 배치 ==> 유효
                answer=mid;
                lt=mid+1; // 간격을 넓혀서 최대 값을 찾아봐야지
            }
            else rt = mid-1; // 간격을 좁혀서 c마리 모두 배치될 수 있게 해야지
        }
        return answer;
    }

    public static void main(String[] args) {
        Main6_10 T = new Main6_10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.Solution(n, c, arr));
    }
}
