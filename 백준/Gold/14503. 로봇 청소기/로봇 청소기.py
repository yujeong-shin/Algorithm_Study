import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
startX, startY, startD = map(int, input().split())
maps = []
for _ in range(n):
    maps.append(list(map(int, input().split())))

# 북(0), 동(1), 남(2), 서(3)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
answer = 0
deque = deque()
deque.append([startX, startY, startD])
while deque:
    cur = deque.popleft()
    cx = cur[0]
    cy = cur[1]
    cd = cur[2]
    # 현재 칸이 아직 청소되지 않은 경우 청소함
    if maps[cx][cy] == 0:
        maps[cx][cy] = 2
        answer += 1
    
    # 주변 4칸 중 청소되지 않은 빈 칸이 있으면 전진
    hasNotCleaned = False
    for i in range(4):
        temp_nx = cx + dx[i]
        temp_ny = cy + dy[i]
        if maps[temp_nx][temp_ny] == 0:
            hasNotCleaned = True

    if hasNotCleaned:
        for i in range(4):
            # 반시계 방향 회전
            if cd - 1 >= 0: # 서, 남, 동
                nd = cd - 1
            else:
                nd = 3 # 북
            cd = nd # 다음 방향 보기위해 업데이트
            
            nx = cx + dx[nd]
            ny = cy + dy[nd]
            if maps[nx][ny] == 0:
                deque.append([nx, ny, nd])
                break
    else:
        nx = cx - dx[cd]
        ny = cy - dy[cd]
        nd = cd
        # 후진할 곳이 벽이라면 멈춤
        if maps[nx][ny] == 1:
            break
        else:
            # 주변 4칸 중 청소되지 않은 칸이 있으면 whle문 재실행
            deque.append([nx, ny, nd])
print(answer)