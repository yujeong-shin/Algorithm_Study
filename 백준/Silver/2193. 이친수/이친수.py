n = int(input())
dp = [0] * n

dp[0] = 1
if n <= 1 :
    print(dp[n-1])
else :
    dp[1] = 1
    for i in range(2, n):
        dp[i] = dp[i-2] + dp[i-1]
    print(dp[n-1])