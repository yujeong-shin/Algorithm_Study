import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
dl = [-1, 1] # 상, 하 이동

def BFS(level, x, y, cnt):
    queue = deque()
    queue.append([level, x, y, cnt])
    visited[level][x][y] = 1
    
    while queue:
        cl, cx, cy, cnt = queue.popleft()
        if maps[cl][cx][cy] == 'E':
            return cnt
        
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < R and 0 <= ny < C and maps[cl][nx][ny] != "#" and visited[cl][nx][ny] == 0:
                visited[cl][nx][ny] = 1
                queue.append([cl, nx, ny, cnt+1]) # 동서남북 탐색. 층 수는 동일
        for i in range(2):
            nl = cl + dl[i]
            if 0 <= nl < L and maps[nl][cx][cy] != "#" and visited[nl][cx][cy] == 0:
                visited[nl][cx][cy] = 1
                queue.append([nl, cx, cy, cnt+1]) # 상하 탐색. 좌표는 동일
    return 0
 
while True:
    L, R, C = map(int, input().split())
    if L==0 and R==0 and C==0:
        break
        
    visited = [[[0 for _ in range(C)] for _ in range(R)] for _ in range(L)]
    maps = []
    for _ in range(L):
        temp = [list(input().rstrip()) for _ in range(R)]
        maps.append(temp)
        input()
        
    for l in range(L):
        for i in range(R):
            for j in range(C):
                if maps[l][i][j] == 'S':
                    count = BFS(l, i, j, 0)
                    if count > 0:
                        print("Escaped in " + str(count) + " minute(s).")
                    else:
                        print("Trapped!")
                    break