import sys
input = sys.stdin.readline

dp = [0, 1, 1, 1, 2, 2, 3, 4, 5] + [0]*92

j=4
for i in range(9, 101):
    dp[i] = dp[i-1] + dp[j]
    j += 1

n = int(input())
numbers = [int(input()) for _ in range(n)]
for num in numbers:
    print(dp[num])