import sys
from collections import deque
input = sys.stdin.readline
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

m, n = map(int, input().split())
maps = []
visited = [[0]*m for _ in range(n)]
for i in range(n):
    maps.append(list(map(int, input().split())))

tmp = 0
queue = deque()
for i in range(n):
    for j in range(m):
        if maps[i][j] == 1:
            queue.append((i, j))
            visited[i][j] = 1
            tmp += 1
# 입력 시 모두 다 익은 경우
if tmp == m*n:
    print(0)
    sys.exit(0)

day = -1
while queue:
    day += 1
    for k in range(len(queue)):
        cx, cy = queue.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 0:
                if visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    maps[nx][ny] = 1
                    queue.append((nx, ny))
                
for i in range(n):
    for j in range(m):
        if maps[i][j] == 0:
            print(-1)
            sys.exit(0)
print(day)