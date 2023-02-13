import java.util.Scanner;

public class Main6_4 {
//    int index;
//    public int[] Solution(int s, int n, int[] arr) {
//        int[] answer = new int[s];
//        for(int x : arr) {
//            if(contains(answer, x)) {
//                // 해당 인덱스를 찾은 후 맨 앞으로 꺼내기
//                for (int i = index; i > 0; i--) {
//                    answer[i] = answer[i-1];
//                }
//                answer[0] = x;
//            }
//            else {
//                for (int i = s-1; i > 0; i--) {
//                    answer[i] = answer[i-1];
//                }
//                answer[0] = x;
//            }
//        }
//        return answer;
//    }
//    public boolean contains(int[] answer, int x) {
//        for (int i = 0; i < answer.length; i++) {
//            if(answer[i] == x) {
//                index = i;
//                return true;
//            }
//        }
//        return false;
//    }

    public int[] Solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for(int x : arr) {
            int pos=-1;
            for (int i = 0; i < size; i++) if(x==cache[i]) pos=i;
            if(pos==-1) { // 해야할 작업이 캐시에 없는 경우
                for (int i = size-1; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            else { // 해야할 작업이 캐시에 있는 경우
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }
    public static void main(String[] args) {
        Main6_4 T = new Main6_4();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : T.Solution(s, n, arr))
            System.out.print(x + " ");
    }
}
