import sys
input = sys.stdin.readline
n, m, r = map(int, input().split())
maps = []
for i in range(n):
    temp = list(map(int, input().split()))
    maps.append(temp)
    
dx = [1, 0, -1, 0] #하, 우, 상, 좌
dy = [0, 1, 0, -1]
def rotate(x, y, limit_x, limit_y):
    cx, cy = x, y
    temp = 0
    for d_idx in range(len(dx)):
        while True:
            nx, ny = cx + dx[d_idx], cy + dy[d_idx]
            if x <= nx <= limit_x and y <= ny <= limit_y:
                if temp > 0:
                    maps[nx][ny], temp = temp, maps[nx][ny]
                else: #최초 1번 수행
                    temp = maps[nx][ny]
                    maps[nx][ny] = maps[cx][cy]
                cx, cy = nx, ny
            else:
                break #범위 벗어나면 방향 회전
                
x, y = 0, 0
while x < n//2 and y < m//2:
    start_x, start_y, limit_x, limit_y = x, y, n-(x+1), m-(y+1) #boundary
    for R in range(r): #r번 회전
        rotate(start_x, start_y, limit_x, limit_y)
    x, y = x+1, y+1

for i in range(len(maps)):
    print(*maps[i])