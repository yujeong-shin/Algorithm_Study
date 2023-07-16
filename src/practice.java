import Main9.Main9_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int time;
    public char state;
    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time o) {
        if(this.time == o.time) return this.state - o.state; //time이 같다면 state 오름차순
        else return this.time - o.time; //time 오름차순
    }
}
public class practice {
    public int Solution(ArrayList<Time> arr){
        int cnt=0, answer=Integer.MIN_VALUE;
        Collections.sort(arr);
        for(Time ob : arr) {
            if(ob.state=='s') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    public static void main(String[] args) {
        practice T = new practice();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int sT = sc.nextInt();
            int eT = sc.nextInt();
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }
        System.out.println(T.Solution(arr));
    }
}
