package Main6;

import java.util.Arrays;
import java.util.Scanner;

public class Main6_8 {
    public int Solution(int n, int m, int[] arr) {
        int answer=0;
        Arrays.sort(arr);
        int lt=0, rt=n-1;
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if(arr[mid]==m) {
                answer = mid+1;
                break;
            }
            else if(arr[mid]>m) rt = mid-1;
            else lt = mid+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main6_8 T = new Main6_8();
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
