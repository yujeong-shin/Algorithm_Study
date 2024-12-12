import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
visited = [[-1] * n for _ in range(n)]
maps = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
result = -sys.maxsize

def dfs(x, y):
    if visited[x][y] != -1:
        return visited[x][y]
    
    max_temp = 1  # 현재 위치를 포함하므로 1로 초기화
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if maps[nx][ny] > maps[x][y]:
                temp = dfs(nx, ny)
                max_temp = max(max_temp, 1 + temp)  # 현재 위치를 포함하므로 1을 더함

    visited[x][y] = max_temp
    return visited[x][y]

for i in range(n):
    for j in range(n):
        result = max(result, dfs(i, j))

print(result)