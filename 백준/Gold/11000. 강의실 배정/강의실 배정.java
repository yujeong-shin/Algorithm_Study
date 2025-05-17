import java.io.*;
import java.util.*;

class Lecture {
    int time;
    char start_end_tp_cd;
    public Lecture(int time, char start_end_tp_cd){
        this.time = time;
        this.start_end_tp_cd = start_end_tp_cd;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(s, 's'));
            lectures.add(new Lecture(e, 'e'));
        }

        Collections.sort(lectures, (l1, l2) -> {
            // 시간이 같다면 시작/종료 구분코드 오름차순 정렬, 아니라면 시간 오름차순 정렬
            if(l1.time == l2.time) {
                return l1.start_end_tp_cd - l2.start_end_tp_cd;
            }
            else {
                return l1.time - l2.time;
            }
        });

        int room_cnt = 0;
        int answer = 0;
        for(Lecture lecture : lectures){
            if(lecture.start_end_tp_cd == 's'){
                room_cnt++;
                answer = Math.max(answer, room_cnt);
            }
            else {
                room_cnt--;
            }
        }
        System.out.println(answer);
    }
}