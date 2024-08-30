import sys

n = int(sys.stdin.readline())
map = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    for j in range(n):
        length = map[i][j]
        
        if(length>0 and i+length<n):
            dp[i+length][j] += dp[i][j]
        if(length>0 and j+length<n):
            dp[i][j+length] += dp[i][j]
print(dp[n-1][n-1])