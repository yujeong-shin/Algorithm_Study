import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
maps = []
for i in range(n):
    maps.append(list(input().strip()))

lands = []
for i in range(n):
    for j in range(m):
        if maps[i][j] == 'L':
            lands.append([i, j, 0])

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
deque = deque()
answer = -sys.maxsize
def BFS(start):
    global answer
    visited = [[0]*m for _ in range(n)]
    deque.append(start)
    visited[start[0]][start[1]] = 1
    
    while deque:
        cur = deque.popleft()
        count = cur[2]
        if count > answer :
            answer = count
        
        for i in range(len(dx)):
            next_x = cur[0] + dx[i]
            next_y = cur[1] + dy[i]
            if next_x>=0 and next_x<n and next_y>=0 and next_y<m and maps[next_x][next_y]=='L':
                if visited[next_x][next_y]==0:
                    visited[next_x][next_y]=1
                    deque.append([next_x, next_y, count+1])

for land in lands:
    BFS(land)

print(answer)