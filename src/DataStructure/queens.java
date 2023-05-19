package DataStructure;

public class queens {
    static int N=4;
    static int[] cols = new int[N+1];
    public static boolean queens(int level) {
        if(!promising(level)) // 꽝인 노드의 경우
            return false; // 탐색 중지. 무르기
        else if(level==N) { // 그래프 맨 아래 노드까지 탐색한 경우
            for (int i = 1; i <= N; i++) {
                System.out.println("("+i+"," +cols[i]+")");
            }
            return true; // 탐색 종료.
        }
        else {
            for (int i = 1; i <= N; i++) { // 모든 자식노드 탐색
                cols[level+1] = i; // 1부터 N까지 열의 위치에 말 놓기
                if(queens(level+1)) // 다음 말을 놓았다면
                    return true; // 계속 다음 말 놓는 동작 반복
            }
            return false;
        }
    }

    public static boolean promising(int level) {
        for (int i = 1; i < level; i++) {
            if(cols[level] == cols[i]) // 같은 열에 놓였는지 검사
                return false;
            else if(level-i == Math.abs(cols[level] - cols[i])) // 같은 대각선에 놓였는지 검사
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        queens(0);
    }
}
