package Main9;

import java.util.*;

class Time implements Comparable<Time> {
    public int time;
    public char state;
    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}
public class Main9_3 {
    public int Solution(ArrayList<Time> arr) {
        int cnt=0, answer=Integer.MIN_VALUE;
        Collections.sort(arr);
        for(Time ob : arr) {
            if(ob.state == 's') cnt++;
            else cnt--;
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main9_3 T = new Main9_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int sT=sc.nextInt();
            int eT=sc.nextInt();
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }
        System.out.println(T.Solution(arr));
    }
}
