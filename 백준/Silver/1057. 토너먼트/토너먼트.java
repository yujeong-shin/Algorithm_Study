import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());

        int round = 0;
        while(jimin != hansu){
            round++;
            jimin = jimin/2 + jimin%2;
            hansu = hansu/2 + hansu%2;
        }
        System.out.println(round);
    }
}
