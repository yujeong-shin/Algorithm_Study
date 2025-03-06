import sys

r, c = map(int, input().split())
maps = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
for i in range(r):
    maps.append(list(input()))

visited = [0]*27 # A:1, B:2, ..., Z:26
answer = 0
def dfs(x, y):
    global answer
    cnt = 0
    for i in range(len(visited)):
        if visited[i] == 1:
            cnt += 1
    answer = max(answer, cnt)
    
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < r and 0 <= ny < c and visited[ord(maps[nx][ny])-64] == 0:
            visited[ord(maps[nx][ny])-64] = 1
            dfs(nx, ny)
            visited[ord(maps[nx][ny])-64] = 0
            
visited[ord(maps[0][0])-64] = 1
dfs(0, 0)
print(answer)