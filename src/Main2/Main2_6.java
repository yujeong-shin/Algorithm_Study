package Main2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2_6 {
    public boolean isPrime(int num) { // 소수 판별
        if(num==1) return false;
        for (int i = 2; i < num; i++) {
            if(num%i==0) return false; // 약수가 있다면 소수X
        }
        return true;
    }

    public ArrayList<Integer> Solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) { // 숫자 뒤집기
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) answer.add(res);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main2_6 T = new Main2_6();
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
