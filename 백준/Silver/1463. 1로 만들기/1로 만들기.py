import sys
input = sys.stdin.readline

n = int(input())
dp = [sys.maxsize for _ in range(n+1)]
dp[n] = 0

for i in range(n-1, 0, -1):
    calc_result1, calc_result2 = sys.maxsize, sys.maxsize
    if i*3 <= n:
        calc_result1 = dp[i*3]
    if i*2 <= n:
        calc_result2 = dp[i*2]
    dp[i] = min(calc_result1, calc_result2, dp[i+1]) + 1
print(dp[1])