package Main7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main7_8 {
//    int answer=0;
//    int dis[] = {1, -1, 5};
//    int[] ch;
//    Queue<Integer> Q = new LinkedList<>();
//    public int DataStructure.BFS(int s, int e){
//        ch = new int[10001];
//        ch[s] = 1;
//        Q.offer(s);
//        int L=0;
//        while (!Q.isEmpty()) {
//            int len = Q.size();
//            for (int i = 0; i < len; i++) {
//                int x = Q.poll();
//                if(x==e) return L;
//                for (int j = 0; j < 3; j++) {
//                    int nx = x+dis[j];
//                    if(nx>=1 && nx<=10000 && ch[nx]==0) {
//                        ch[nx]=1;
//                        Q.offer(nx);
//                    }
//                }
//            }
//            L++;
//        }
//        return 0;
//    }

    int answer=0;
    int direction[] = {1, -1, 5};
    int[] check = new int[10001];
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        int L=0;
        check[s] = 1;
        Q.offer(s);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int cur = Q.poll();
                if(cur==e) return L;

                for (int j = 0; j < 3; j++) {
                    int x = cur + direction[j];
                    if(check[x]==0 && x>=1 && x<=10000 ) {
                        check[x] = 1;
                        Q.offer(x);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main7_8 T = new Main7_8();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
