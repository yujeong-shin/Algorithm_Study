import sys
N, S = map(int, input().split())
num = list(map(int, input().split()))

result = sys.maxsize
sum = 0
lt = 0
rt = 0

while True:
    if sum >= S:
        result = min(result, rt-lt)
        sum -= num[lt]
        lt += 1
    elif rt == N:
        break
    else:
        sum += num[rt]
        rt += 1

if result == sys.maxsize:
    print(0)
else:
    print(result)