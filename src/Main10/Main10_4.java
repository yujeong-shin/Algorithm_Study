package Main10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    public int s, h, w;
    public Brick(int s, int h, int w){
        this.s = s;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick o){
        return o.s - this.s;
    }
}
public class Main10_4 {
    static int[] dy;
    public int Solution(ArrayList<Brick> arr){
        int answer=0;
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        answer=dy[0];
        for (int i = 1; i < dy.length; i++) {
            int max_h=0;
            for (int j = i-1; j >= 0; j--) {
                if(arr.get(j).w > arr.get(i).w && dy[j]>max_h) max_h = dy[j];
            }
            dy[i] = arr.get(i).h + max_h;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main10_4 T = new Main10_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n];
        ArrayList<Brick> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brick(a, b, c));
        }
        System.out.println(T.Solution(arr));
    }
}
