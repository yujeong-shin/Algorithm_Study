import sys
input = sys.stdin.readline

d, p = map(int, input().split())
dp = [0]*(d+1)
dp[0] = sys.maxsize
for i in range(1, p+1):
    l, c = map(int, input().split())
    for j in range(d, l-1, -1):
        dp[j] = max(dp[j], min(c, dp[j-l]))
print(dp[d])