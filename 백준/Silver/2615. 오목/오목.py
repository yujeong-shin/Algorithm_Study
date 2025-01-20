import sys
input = sys.stdin.readline

n = 19
maps = []
for i in range(n):
    temp = list(map(int, input().split()))
    maps.append(temp)

dx = [0, 0, -1, 1, -1, 1, 1, -1]
dy = [-1, 1, 0, 0, 1, -1, 1, -1]
def calc_cnt(x, y, d_idx):
    cnt = 0
    num = maps[x][y]
    while True:
        nx, ny = x+dx[d_idx], y+dy[d_idx]
        if 0 <= nx < 19 and 0 <= ny < 19 and maps[nx][ny] == num:
            cnt += 1
            x, y = nx, ny
        else:
            return cnt

answer = 0
answer_xy = []
for i in range(n):
    for j in range(n):
        if maps[i][j] != 0:
            cnt = []
            for d in range(8):
                cnt.append(calc_cnt(i, j, d))
            if cnt[0] + cnt[1] == 4:
                answer = maps[i][j]
                answer_xy.append((i+1, j+1))
                break
            elif cnt[2] + cnt[3] == 4:
                answer = maps[i][j]
                answer_xy.append((i+1, j+1))
                break
            elif cnt[4] + cnt[5] == 4:
                answer = maps[i][j]
                if cnt[5] > 0:
                    answer_x = (i+1) + (dx[5]*cnt[5])
                    answer_y = (j+1) + (dy[5]*cnt[5])
                    answer_xy.append((answer_x, answer_y))
                else:
                    answer_xy.append((i+1, j+1))
                break
            elif cnt[6] + cnt[7] == 4:
                answer = maps[i][j]
                answer_xy.append((i+1, j+1))
                break
if answer != 0:
    print(answer)
    print(*answer_xy[0])
else:
    print(0)