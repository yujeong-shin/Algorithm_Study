from collections import deque

M, N, H = map(int, input().split())
tomato = [[[0]*M for _ in range(N)] for _ in range(H)]
visited = [[[0]*M for _ in range(N)] for _ in range(H)]
dx, dy, dz = [-1, 0, 1, 0], [0, 1, 0, -1], [1, -1]
def rangeValidation(z, x, y):
    if 0 <= z < H and 0 <= x < N and 0 <= y < M:
        return True
    else:
        return False

for h in range(H): # layer
    for n in range(N): # row
        arr = list(map(int, input().split()))
        tomato[h][n] = arr
        
queue = deque()
for h in range(H):
    for n in range(N):
        for m in range(M):
            if tomato[h][n][m] == 1:
                queue.append((h, n, m))
                visited[h][n][m] = True
                
day = -1
while queue:
    day += 1 
    for l in range(len(queue)):
        z, x, y = queue.popleft()
        # 왼쪽, 오른쪽, 앞, 뒤
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if rangeValidation(z, nx, ny) and not visited[z][nx][ny] and tomato[z][nx][ny] == 0:
                visited[z][nx][ny] = True
                tomato[z][nx][ny] = 1 
                queue.append((z, nx, ny))
        # 위, 아래
        for i in range(2):
            nz = z + dz[i]
            if rangeValidation(nz, x, y) and not visited[nz][x][y] and tomato[nz][x][y] == 0:
                visited[nz][x][y] = True
                tomato[nz][x][y] = 1 
                queue.append((nz, x, y))
                
exists = any(0 in row for layer in tomato for row in layer)
if exists:
    print(-1)
else:
    print(day)