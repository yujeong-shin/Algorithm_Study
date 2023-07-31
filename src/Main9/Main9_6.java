package Main9;

import java.util.Scanner;

public class Main9_6 {
    static int[] unf;
    public static int Find(int v) {
        //v와 연결된 친구 중 가장 마지막 친구를 찾으면서 그 값을 unf[v]에 업데이트
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb; //a-b 친구 연결
    }

    public static void main(String[] args){
        Main9_6 T = new Main9_6();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=1; i<=m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            T.Union(a, b);
        }
        int a=kb.nextInt();
        int b=kb.nextInt();
        int fa=T.Find(a);
        int fb=T.Find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
