import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            // m=5, n=7일 경우 35번째 해인 <5, 7>을 계산하면 나머지가 0이기 때문에
            // -1해서 넘겨주고, 값을 담을 때 +1해서 담아준다.
            int X = Integer.parseInt(st.nextToken()) - 1;
            int Y = Integer.parseInt(st.nextToken()) - 1;
            calc(M, N, X, Y);
        }
        System.out.println(sb);
    }
//    static void calc(int m, int n, int x, int y){
//        int small, large;
//        if(m<n){
//            small = m;
//            large = n;
//        }
//        else {
//            small = n;
//            large = m;
//        }
//        int[] arr = new int[large];
//
//        // value의 반복 사이클
//        int value = x;
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = value;
//            // m과 n 차이만큼 value 감소
//            value -= Math.abs(m-n);
//            if(value <= 0) value += large;
//        }
//
//        int idx = -1;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] == y) {
//                idx = i;
//                break;
//            }
//        }
//        if(idx == -1){
//            sb.append(-1);
//        }
//        else{
//            sb.append((small * (idx)) + x);
//        }
//        sb.append("\n");
//    }

    static void calc(int m, int n, int x, int y){
        int result = -1;
        for (int i = x; i < (m * n); i += m) {
            if (i % n == y) {
                result = i+1; // +1로 감소한 값 복구
                break;
            }
        }
        sb.append(result + "\n");
    }

}
