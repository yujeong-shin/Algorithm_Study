package Main7;

public class Main7_4 {
    static int[] fibo;
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1) return fibo[1]=1;
        else if(n==2) return fibo[2]=1;
        else return fibo[n] = DFS(n-2)+DFS(n-1);
    }
    public static void main(String[] args) {
        Main7_4 T = new Main7_4();
        int n = 45;
        fibo = new int[n+1];
        T.DFS(n);
        for (int i = 1; i <= n; i++) System.out.println(fibo[i]+" ");
    }
}
