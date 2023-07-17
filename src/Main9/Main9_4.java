package Main9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;
    Lecture(int money, int date){
        this.money = money;
        this.date = date;
    }
    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
}

public class Main9_4 {
    static int n, max=Integer.MIN_VALUE;
    public int Solution(ArrayList<Lecture> arr) {
        int answer=0;
        Collections.sort(arr);
        // PriorityQueue<Integer> pQ = new PriorityQueue<>(); 기본 : 작은값 꺼냄
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j=0;
        for(int i=max; i>0; i--) {  //date값이 max값부터 1까지 접근
                                    //(60, 5), (50, 3)처럼 date값 사이 비어있을 경우까지 고려한 방법
            for(; j<n; j++) { //arr에 순차적으로 접근
                if(arr.get(j).date<i) break;
                pQ.offer(arr.get(j).money); //현재 max보다 크거나 같은 값들만 offer()
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args){
        Main9_4 T = new Main9_4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if(d>max) max=d;
        }
        System.out.println(T.Solution(arr));
    }
}
