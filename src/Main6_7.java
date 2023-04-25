/*
import java.util.*;
class Point implements Comparable<Point>{ // Point 객체를 정렬
    public int x,y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x == o.x) return this.y-o.y; // 오름차순 정렬
        else return this.x-o.x;
    }
}

public class Main6_7 {
//    public int[][] Solution(int n, int[][] arr) {
//        //2차월 배열 정렬 0번째 열 다음 1번째 열 기준(다중 배열 정렬)
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1]; // 오름차순 o1[1] - o2[1] 내림차순 o2[1] - o1[1]
//                } else {
//                    return o1[0] - o2[0];
//                }
//            }
//        });
//
//        return arr;
//    }
//
//    public static void main(String[] args) {
//        Main6_7 T = new Main6_7();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] arr = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        T.Solution(n, arr);
//        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i][0] + " " + arr[i][1]);
//        }
//    }

    public static void main(String[] args) {
        Main6_7 T = new Main6_7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr); // 재정의한 compareTo에 의해서 정렬됨
        for(Point o : arr) System.out.println(o.x + " " + o.y);
    }
}*/
