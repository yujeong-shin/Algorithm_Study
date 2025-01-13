import sys
input = sys.stdin.readline
n = int(input())
bomb = [list(input().strip()) for _ in range(n)] # 지뢰 위치 정보
open_close = [list(input().strip()) for _ in range(n)] # 열린 칸 정보
res = [[0]*n for _ in range(n)]

dx = [-1, -1, -1, 0, 1, 1, 1, 0]
dy = [-1, 0, 1, 1, 1, 0, -1, -1]

flag = False
for x in range(n):
    for y in range(n):
        if bomb[x][y] == '*' and open_close[x][y] == 'x':
            flag = True
        if bomb[x][y] == '*':
            for d_idx in range(8):
                nx, ny = x + dx[d_idx], y + dy[d_idx]
                if 0 <= nx < n and 0 <= ny < n and bomb[nx][ny] != '*':
                    res[nx][ny] += 1

if not flag:                    
    for x in range(n):
        temp = []
        for y in range(n):
            if open_close[x][y] == 'x':
                temp.append(str(res[x][y]))
            else:
                temp.append('.')
        print("".join(temp))
else:
    for x in range(n):
        temp = []
        for y in range(n):
            if bomb[x][y] == '*':
                temp.append('*')
                continue
            elif open_close[x][y] == 'x':
                temp.append(str(res[x][y]))
            else:
                temp.append('.')
        print("".join(temp))