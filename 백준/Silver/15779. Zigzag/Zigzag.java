import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // 배열의 0, 1 번째 요소를 가지고 초기 결과 값, 초기 flag값 설정
        int max = 1;
        if(N >= 2){
            int result = 2;
            boolean preFlag = calcFlag(arr, 0, 1);

            for (int i = 1; i < N-1; i++) {
                // 배열의 1, 2 번째 요소의 flag
                boolean flag = calcFlag(arr, i, i+1);
                if(preFlag == flag) { // 이전 증감 부호와 같다면 리셋
                    max = Math.max(result, max);
                    result=2;
                }
                else{ // 이전 증감 부호와 다르다면 길이 증가
                    result++;
                    max = Math.max(result, max);
                }
                preFlag = flag; // 이전 부호 값을 현재 부호 값으로 설정
            }
        }
        else {
            max = N;
        }
        System.out.println(max);
    }

    static boolean calcFlag(int[] arr, int a, int b){
        return arr[a] - arr[b] < 0; // 앞 숫자 - 뒤 숫자 값이 양수면 true(양수 부호)
    }
}
