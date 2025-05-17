import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int max_num, answer;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         int m = Integer.parseInt(st.nextToken());
         arr = new int[n];
         st = new StringTokenizer(br.readLine());
         
         for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max_num = Math.max(max_num, arr[i]);
         }
         
         bineary_search(m, 0, max_num);
         System.out.println(answer);
    }

    static void bineary_search(int M, int start, int end){
        if(start > end) return;

        int mid = (start+end)/2;
        
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > mid){
                sum += (arr[i]-mid);
            }
        }
        if(sum >= M){
            answer = Math.max(answer, mid);
            bineary_search(M, mid+1, end);
        }
        else{
            bineary_search(M, start, mid-1);
        }
    }
}