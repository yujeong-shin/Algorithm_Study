import sys
input = sys.stdin.readline

dp0, dp1 = [0]*41, [0]*41
dp0[0], dp0[1] = 1, 0
dp1[0], dp1[1] = 0, 1

for i in range(2, 41):
    dp0[i] = dp0[i-1] + dp0[i-2]
    dp1[i] = dp1[i-1] + dp1[i-2]

n = int(input())
numbers = [int(input()) for _ in range(n)]
for num in numbers:
    print(dp0[num], end=" ")
    print(dp1[num])
