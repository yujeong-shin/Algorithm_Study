import java.util.ArrayList;
import java.util.Scanner;
//class Point {
//    public int x, y;
//    Point(int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//}

public class Main8_15 {
    static int n, m, len, answer=Integer.MAX_VALUE;
    static ArrayList<Point> hs, pz;
    static int[] combi;

    private void DFS(int L, int s) {
        if(L==m) {
            int sum=0;
            for(Point h : hs) {
                int dis=Integer.MAX_VALUE;
                for(int i : combi){
                    dis=Math.min(dis, Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
                }
                sum+=dis;
            }
            answer = Math.min(answer, sum);
        }
        else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Main8_15 T = new Main8_15();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        hs = new ArrayList<>();
        pz = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if(num == 1) hs.add(new Point(i, j)); //집
                else if(num == 2) pz.add(new Point(i, j)); //피자집
            }
        }
        len=pz.size();
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}