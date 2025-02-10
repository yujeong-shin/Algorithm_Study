import sys
input = sys.stdin.readline

n, t = map(int, input().split())
dp = [[0]*(t+1) for _ in range(n+1)]
for i in range(1, n+1):
    k, s = map(int, input().split())
    for j in range(1, t+1):
        if j < k:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], s + dp[i-1][j-k])
print(dp[n][t])