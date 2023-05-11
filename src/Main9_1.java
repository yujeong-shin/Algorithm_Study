import java.util.*;

class Body implements Comparable<Body>{
    public int h, w;
    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}

public class Main9_1 {
    public int Solution(ArrayList<Body> arr, int n) {
        int answer=0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Body ob : arr) {
            if(ob.w > max) {
                max = ob.w;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main9_1 T = new Main9_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }
        System.out.println(T.Solution(arr, n));
    }
}