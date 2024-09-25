import sys
input = sys.stdin.readline

dp = [0, 1, 1, 1] + [0]*97

j=4
for i in range(4, 101):
    dp[i] = dp[i-2] + dp[i-3]

n = int(input())
numbers = [int(input()) for _ in range(n)]
for num in numbers:
    print(dp[num])