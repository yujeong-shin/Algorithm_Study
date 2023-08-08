package Main9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2>{
    public int vex, cost;
    Edge2(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge2 ob){
        return this.cost - ob.cost;
    }
}
public class Main9_7_2 {
    public static void main(String[] args) {
        Main9_7_2 T = new Main9_7_2();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Edge2>> graph = new ArrayList<ArrayList<Edge2>>();
        for(int i=0; i<=v; i++) graph.add(new ArrayList<Edge2>());
        int[] ch = new int[v+1];
        for(int i=0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge2(b, c));
            graph.get(b).add(new Edge2(a, c));
        }

        PriorityQueue<Edge2> pQ = new PriorityQueue<>();
        int answer=0;
        pQ.add(new Edge2(1, 0));
        while(!pQ.isEmpty()){
            Edge2 tmp = pQ.poll();
            if(ch[tmp.vex]==0) {
                ch[tmp.vex]=1;
                answer += tmp.cost;
                for(Edge2 ob : graph.get(tmp.vex)) {
                    if(ch[ob.vex]==0) pQ.add(new Edge2(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }
}
