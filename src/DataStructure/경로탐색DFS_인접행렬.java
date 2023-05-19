package DataStructure;

import java.util.Scanner;

public class 경로탐색DFS_인접행렬 {
    static int n, m, answer=0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if(graph[v][i]==1 && ch[i]==0) { //간선이 있고, 탐색하지 않은 노드인 경우
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색DFS_인접행렬 T = new 경로탐색DFS_인접행렬();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for (int i = 0; i < m; i++) { //인접행렬
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
