package Main7;

public class Main7_2 {
    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n/2);
            System.out.println(n%2+" ");
        }
    }

    public static void main(String[] args) {
        Main7_2 T = new Main7_2();
        T.DFS(11);
    }
}
