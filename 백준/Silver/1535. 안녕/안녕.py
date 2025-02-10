import sys
input = sys.stdin.readline

n = int(input())
healths = [0] + list(map(int, input().split()))
happies = [0] + list(map(int, input().split()))

dp = [[0]*101 for _ in range(n+1)]
result = 0
for i in range(1, n+1):
    health, happy = healths[i], happies[i]
    for j in range(100, -1, -1):
        if j > health:
            dp[i][j] = max(dp[i-1][j], happy + dp[i-1][j-health])
        else:
            dp[i][j] = dp[i-1][j]
            
for i in range(101):
    result = max(result, dp[n][i])
print(result)