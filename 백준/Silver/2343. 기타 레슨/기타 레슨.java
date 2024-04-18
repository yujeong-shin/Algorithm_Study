import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = -1, right = 0;
        // left는 최대 원소 값, right는 원소들의 합
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        int blueraySize;
        while(left<=right){
            blueraySize = (left+right)/2;
            int cnt = 1, sum = 0;
            for (int i = 0; i < N; i++) {
                if(sum + arr[i] > blueraySize) {
                    cnt++;
                    sum = arr[i];
                }
                else {
                    sum += arr[i];
                }
            }
            if(cnt <= M) {
                // 가능한 최소 크기의 블루레이를 찾고자 하므로,
                // 현재 크기보다 더 작은 크기로도 모든 강의를 담을 수 있는지 확인하기 위해 right를 조정
                right = blueraySize-1;
            }
            else {
                // blueraySize에 강의가 모두 들어가지 않는 경우
                left = blueraySize+1;
            }
        }
        System.out.println(left);
    }
}