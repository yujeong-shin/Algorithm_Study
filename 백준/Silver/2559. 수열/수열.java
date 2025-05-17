import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }

        int answer = sum;
        int lt = 0, rt = k-1;
        while(rt < arr.length-1){
            sum -= arr[lt++];
            sum += arr[++rt];
            answer = Math.max(answer, sum);

        }
        System.out.println(answer);
    }
}