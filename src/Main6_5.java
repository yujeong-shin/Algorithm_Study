import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main6_5 {
//    public char Solution(int n, int[] arr) {
//        char answer='U';
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int x : arr) {
//            map.put(x, map.getOrDefault(x, 0)+1);
//        }
//        for(int key : map.keySet()) {
//            if(map.get(key)!=1) {
//                return 'D';
//            }
//        }
//        return answer;
//    }

    public String Solution(int n, int[] arr) {
        String answer="U";
        Arrays.sort(arr);
        for (int i = 0; i < n-1; i++) {
            if(arr[i]==arr[i+1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args) {
        Main6_5 T = new Main6_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.Solution(n, arr));
    }
}