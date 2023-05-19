/*
import java.util.*;


class Time implements Comparable<Time> {
    public int s, e; //start, end
    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }
    public int compareTo(Time o) {
        if(this.e == o.e) return this.s - o.s; //종료 시간이 같으면 시작 시간 기준 오름차순 정렬
        else return this.e - o.e; //종료 시간 기준 오름차순 정렬
    }
}
class Main9_2 {
    public int Solution(ArrayList<Time> arr, int n) {
        int answer=0;
        Collections.DataStructure.sort(arr);
        int end_time=0;
        for(Time ob : arr) {
            if(ob.s >= end_time) {
                end_time = ob.e;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main9_2 T = new Main9_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Time(s, e));
        }
        System.out.println(T.Solution(arr, n));
    }
}
 */