import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

m, n = map(int, input().split())
visited = [[-1]*n for _ in range(m)]
maps = [list(map(int, input().split())) for _ in range(m)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
def dfs(cx, cy):
    if cx == m-1 and cy == n-1:
        return 1
    
    if visited[cx][cy] == -1:
        visited[cx][cy] = 0
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < m and 0 <= ny < n and maps[cx][cy] > maps[nx][ny]:
                visited[cx][cy] += dfs(nx, ny)
                
    return visited[cx][cy]

print(dfs(0, 0))