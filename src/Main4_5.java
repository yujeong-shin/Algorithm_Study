import java.util.*;

public class Main4_5 {
    public int Solution(int n, int k, int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al_unique = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    al.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        // 중복되지 않는 수만 al_unique에 저장
        for(int x : al) {
            if(!al_unique.contains(x))
                al_unique.add(x);
        }
        // 내림차순 정렬
        al_unique.sort(Comparator.reverseOrder()); // 혹은 Collections.sort(al, Collections.reverseOrder());
        int cnt=0;
        for(int x : al_unique) {
            cnt++;
            if(cnt==k) return x;
        }
        return -1;

//        int answer=-1;
//        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
//        for (int i = 0; i < n; i++) { // 끝까지 돌아도 상관없음. 자동으로 끝남
//            for (int j = i+1; j < n; j++) {
//                for (int l = j+1; l < n; l++) {
//                    Tset.add(arr[i]+arr[j]+arr[l]);
//                }
//            }
//        }
//        int cnt=0;
//        for(int x : Tset) {
//            cnt++;
//            if(cnt==k) return x;
//        }
//        return answer; // for문에서 끝까지 거짓일시 -1 반환
    }

    public static void main(String[] args) {
        Main4_5 T = new Main4_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.Solution(n, k, arr));
    }
}
