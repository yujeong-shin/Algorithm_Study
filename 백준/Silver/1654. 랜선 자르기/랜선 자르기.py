import sys
k, n = map(int, sys.stdin.readline().split())
lansuns = []
for _ in range(k):
    num = int(input())
    lansuns.append(num)

start, end = 1, max(lansuns)
answer = -sys.maxsize
while start <= end:
    sum = 0
    mid = (start + end) // 2

    for lansun in lansuns:
        sum += (lansun//mid)
            
    if sum >= n:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)