import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
pts = [tuple(map(int, input().split())) for _ in range(n)]

cx = Counter(x for x, y in pts)
cy = Counter(y for x, y in pts)

answer = 0
for x, y in pts:
    # 같은 x에 속한 다른 점 수 * 같은 y에 속한 다른 점 수
    answer += (cx[x] - 1) * (cy[y] - 1)

print(answer)