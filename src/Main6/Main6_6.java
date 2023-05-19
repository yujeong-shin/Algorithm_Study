package Main6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main6_6 {
    public ArrayList<Integer> Solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if(tmp[i]!=arr[i]) answer.add(i+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main6_6 T = new Main6_6();
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

