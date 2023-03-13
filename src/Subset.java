public class Subset {
    static int n;
    static int[] ch;
    public void DFS(int L) {
        if(L==n+1){ //ch배열에서 1로 체크된 인덱스를 출력
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if(ch[i]==1) tmp+=(i + " ");
            }
            if(tmp.length()>0) System.out.println(tmp);
        }
        else{
            ch[L]=1; //L 원소를 포함
            DFS(L+1);
            ch[L]=0; //L 원소를 포함X
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        Subset T = new Subset();
        n=3;
        ch = new int[n+1]; //트리의 max level까지 표현하기 위해
        T.DFS(1);
    }
}
