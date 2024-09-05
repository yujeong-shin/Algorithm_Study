import sys
n = int(sys.stdin.readline())
dp = [0 for _ in range(n+1)]

for i in range(1, n+1):
    t, p = map(int, sys.stdin.readline().split())
    dp[i] = max(dp[i-1], dp[i])
    
    finish_day = i + t - 1
    if(finish_day <= n):
        dp[finish_day] = max(dp[finish_day], dp[i-1]+p)

print(dp[-1])