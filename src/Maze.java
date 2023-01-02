public class Maze {
    private static int N=8;
    private static int[][] maze = {
            {0,0,0,0,0,0,0,1},
            {0,1,1,0,1,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,0,0,1,1,0,0},
            {0,1,1,1,0,0,1,1},
            {0,1,0,0,0,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,1,1,0,1,0,0}
    };

    private static final int PATHWAY_COLOUR = 0;
    private static final int WALL_COLOUR = 1;
    private static final int BLOCKED_COLOUR = 2; // 방문해서 PATH_COLOUR이었다가 경로가 아니라고 판단된 셀
    private static final int PATH_COLOUR = 3; // 방문했고 아직 꽝인지 출구까지 경로인지 모르는 셀

    public static boolean findMazePath(int x, int y) {
        if(x<0 || y<0 || x>=N || y>=N) return false;
        else if(maze[x][y] != PATHWAY_COLOUR) return false;
        else if(x==N-1 && y==N-1) {
            maze[x][y] = PATH_COLOUR;
            return true;
        }
        else {
            maze[x][y] = PATH_COLOUR;
            if(findMazePath(x,y+1) || findMazePath(x+1,y) || findMazePath(x, y-1) || findMazePath(x-1, y))
                return true;
            maze[x][y] = BLOCKED_COLOUR;
            return false;
        }
    }

    public static void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMaze();
        findMazePath(0,0);
        System.out.println();
        printMaze();
    }
}
