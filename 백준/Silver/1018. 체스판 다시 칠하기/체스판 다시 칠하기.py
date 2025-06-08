import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maps = [list(input().rstrip()) for _ in range(n)]
# for row in maps:
#     print(row)

answer = sys.maxsize
for i in range(0, n-7): # 보드 행 범위 결정 
    for j in range(0, m-7): # 보드 열 범위 결정
        repaint_w = 0 # 시작이 W인 체스판
        repaint_b = 0 # 시작이 B인 체스판
        for k in range(i, i+8):
            for l in range(j, j+8):
                cur = maps[k][l]
                if (k+l) % 2 == 0:
                    if cur != 'W': repaint_w += 1
                    if cur != 'B': repaint_b += 1
                else:
                    if cur != 'B': repaint_w += 1
                    if cur != 'W': repaint_b += 1
        answer = min(answer, repaint_w, repaint_b)
print(answer)