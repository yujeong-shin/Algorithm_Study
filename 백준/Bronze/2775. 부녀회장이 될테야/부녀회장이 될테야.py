import sys
input = sys.stdin.readline

tc = int(input())
for t in range(tc):
    k = int(input())
    n = int(input())
    dp = [[0]*n for _ in range(k+1)]
    dp[0] = [i for i in range(1, n+1)]
    
    for i in range(1, k+1):
        for j in range(n):
            if j==0:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
    print(dp[k][n-1])