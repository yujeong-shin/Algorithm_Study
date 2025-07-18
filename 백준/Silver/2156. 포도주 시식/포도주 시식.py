import sys
input = sys.stdin.readline

n = int(input())
num = [int(input()) for _ in range(n)]

if n == 0:
    print(0)
elif n == 1:
    print(num[0])
elif n == 2:
    print(num[0] + num[1])
else:
    dp = [0] * n
    dp[0] = num[0]
    dp[1] = num[0] + num[1]
    dp[2] = max(dp[1], num[0] + num[2], num[1] + num[2])
    for i in range(3, n):
        dp[i] = max(
            dp[i-1],  # 현재 안 마심
            dp[i-2] + num[i],  # 이전 안 마시고 현재만
            dp[i-3] + num[i-1] + num[i]  # 이전 + 현재 마심 (2연속)
        )
    print(dp[n-1])
