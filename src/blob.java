import java.util.Scanner;

public class blob {
    private static int N=8;
    private static int[][] grid = {
            {1,0,0,0,0,0,0,1},
            {0,1,1,0,0,1,0,0},
            {1,1,0,0,1,0,1,0},
            {0,0,0,0,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {1,0,0,0,1,0,0,1},
            {0,1,1,0,0,1,1,1}
    };

    private static final int BACKGOUND_COLOR = 0;
    private static final int IMAGE_COLOUR = 1;
    private static final int ALREADY_COUNTED = 2;

    public static int countCells(int x, int y) {
        if(x<0 || y<0 || x>=N || y>=N) return 0; // 그리드를 벗어난 경우
        else if(grid[x][y] != IMAGE_COLOUR) return 0; // backgroud pixel이거나 이미 개수를 센 pixel일 경우
        else {
            grid[x][y] = ALREADY_COUNTED;
            return 1 + countCells(x, y+1) + countCells(x+1, y+1) + countCells(x+1, y) +
                    countCells(x+1, y-1) + countCells(x, y-1) + countCells(x-1, y-1) +
                    countCells(x-1, y) + countCells(x-1, y+1);
            // 북, 북동, 동, 동남, ... 시계 방향으로 근접 픽셀에서 해당 픽셀과 이어지는지 탐색
        }
    }


    public static void main(String[] args) {
        System.out.println(countCells(5,3));
    }
}