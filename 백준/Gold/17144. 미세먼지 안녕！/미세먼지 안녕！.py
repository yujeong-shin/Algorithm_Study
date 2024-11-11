import sys
from collections import deque
input = sys.stdin.readline

r, c, t = map(int, input().split())
maps = []
for _ in range(r):
    maps.append(list(map(int, input().split())))

# 북(0), 동(1), 남(2), 서(2)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for _ in range(t): #t초 반복
    # 각 라운드마다 미세먼지 정보, 공기청정기 정보 저장
    # 큐에 초기 정보를 저장함으로써 동시 확산을 고려
    cleaner = []
    queue = deque()
    for i in range(r):
        for j in range(c):
            if maps[i][j] == -1:
                cleaner.append([i, j]) # 공기청정기 상/하 좌표
            elif maps[i][j] > 0:
                queue.append([i, j, maps[i][j]]) # 미세먼지 좌표, 미세먼지 양
    # 미세먼지 확산
    while queue:
        cur = queue.popleft()
        cx, cy, cv = cur[0], cur[1], cur[2] # x좌표, y좌표, 미세먼지 양
        cnt = 0
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < r and 0 <= ny < c: #다음 칸이 벽이 아니고
                if maps[nx][ny] != -1: # 공기청정기가 아닌 경우
                    cnt += 1
                    maps[nx][ny] += (cv//5)
        total_minus_value = (cv//5) * cnt
        maps[cx][cy] -= total_minus_value # 확산된 횟수만큼 현재 미세먼지 양 차감

    # 공기청정기 작동
    x, y = cleaner[0][0], 1 # cleaner : [ [2, 0], [3, 0]]
    idx = 1 # 동에서 시작. 동 북 서 남
    temp = 0 # 공기청정기에서 나오는 바람
    while True:
        nx = x + dx[idx]
        ny = y + dy[idx]
        if nx == r or ny == c or nx == -1 or ny == -1: # 벽에 닿았을 때
            idx = (idx-1)%4 # 0의 경우 -1 mod 4 = 3이 된다 a−b×⌊a/b⌋
            continue
        if x == cleaner[0][0] and y == 0: # 공기청정기 위치로 다시 이동
            break
        maps[x][y], temp = temp, maps[x][y] # swap
        x, y = nx, ny
        
    x, y = cleaner[1][0], 1 # cleaner : [ [2, 0], [3, 0]]
    idx = 1 # 동에서 시작. 동 남 서 북
    temp = 0
    while True:
        nx = x + dx[idx]
        ny = y + dy[idx]
        if nx == r or ny == c or nx == -1 or ny == -1: # 벽에 닿았을 때
            idx = (idx+1)%4
            continue
        if x == cleaner[1][0] and y == 0: # 공기청정기 위치로 다시 이동
            break
        maps[x][y], temp = temp, maps[x][y] # swap
        x, y = nx, ny
    
answer = 0
for i in range(r):
    for j in range(c):
        answer += maps[i][j]
print(answer+2)