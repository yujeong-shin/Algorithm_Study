import sys
input = sys.stdin.readline

n = int(input())
find_xy = int(input())

snail = [[0]*n for _ in range(n)]
num = 1
x, y = n//2, n//2
snail[x][y] = num

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
direction = -1

answer = []
if find_xy == 1:
    answer.append(x+1)
    answer.append(y+1)
for dis in range(1, n+1):
    for cnt in range(2):
        direction = (direction + 1) % 4 # 시계 방향 회전
        
        for move in range(dis): # dis번 이동 및 num 삽입
            x, y = x + dx[direction], y + dy[direction]
            if dis == n and (not 0 <= x < n or not 0 <= y < n): # 마지막 반복
                break
            num += 1
            if num == find_xy:
                answer.append(x+1)
                answer.append(y+1)
            snail[x][y] = num
            
for i in range(len(snail)):
    print(*snail[i])
print(*answer)